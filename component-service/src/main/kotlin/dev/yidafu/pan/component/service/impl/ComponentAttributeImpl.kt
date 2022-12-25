package dev.yidafu.pan.component.service.impl

import dev.yidafu.pan.component.common.exception.attribute.ComponentAttributeCreateFialException
import dev.yidafu.pan.component.common.exception.attribute.IllegalComponentAttributeOwnerException
import dev.yidafu.pan.component.common.exception.attribute.NonexistentComponentAttributeException
import dev.yidafu.pan.component.convertor.ComponentAttributeConvertor
import dev.yidafu.pan.component.domain.mapper.*
import dev.yidafu.pan.component.domain.dto.SaveComponentAttributeDTO
import dev.yidafu.pan.component.domain.dto.UpdateComponentAttributeDTO
import dev.yidafu.pan.component.domain.mapper.ComponentAttributeDynamicSqlSupport.componentAttribute
import dev.yidafu.pan.component.domain.model.ComponentAttribute
import dev.yidafu.pan.component.service.ComponentAttributeService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

import java.util.*
import java.util.function.Function
import java.util.function.Predicate
import java.util.stream.Collectors

@Service
class ComponentAttributeImpl : ComponentAttributeService {
    @Autowired
    var mapper: ComponentAttributeMapper? = null

    @Autowired
    var convertor: ComponentAttributeConvertor? = null

    override fun findOneById(id: Long): ComponentAttribute {
        return mapper?.selectOne{
            where {
                componentAttribute.id isEqualTo  id
            }
        } ?: throw NonexistentComponentAttributeException();
    }

    override fun findOneByAttr(attr: String): ComponentAttribute {
       return mapper!!.selectOne {
            where {
                componentAttribute.attr isEqualTo attr
            }
        } ?: throw NonexistentComponentAttributeException();
    }

    override fun findAllByOwner(ownerId: Long): List<ComponentAttribute> {
        return mapper?.select {
            where {
                componentAttribute.ownerId isEqualTo ownerId
            }
        } ?: Collections.emptyList();
    }

    override fun createOne(dto: SaveComponentAttributeDTO): ComponentAttribute {
        val componentAttribute: ComponentAttribute = convertor!!.from(dto)
        mapper?.insert(componentAttribute)
        val id = componentAttribute.id;
        val attr = id?.let { findOneById(it)  }
        return attr ?: throw ComponentAttributeCreateFialException()
    }

    override fun batchCreate(list: List<SaveComponentAttributeDTO>): List<ComponentAttribute> {
        val ownerId: Long = list[0].ownerId ?: throw IllegalComponentAttributeOwnerException();

        val isTheSomeOwner = list.stream()
            .allMatch(Predicate<SaveComponentAttributeDTO> { attr: SaveComponentAttributeDTO -> attr.ownerId == ownerId })

        if (!isTheSomeOwner) {
            throw IllegalComponentAttributeOwnerException()
        }
        val attributeList: List<ComponentAttribute> = convertor!!.from(list)
        mapper!!.insertMultiple(attributeList)
        return findAllByOwner(ownerId)
    }

    override fun updateByAttr(attr: String, value: String): ComponentAttribute {
        mapper!!.update {
            set(componentAttribute.value).equalTo(value)
            where {
                componentAttribute.attr isEqualTo attr
            }
        }

        return findOneByAttr(attr)
    }

    override fun updateById(id: Long, value: String): ComponentAttribute {
        mapper!!.update {
            set(componentAttribute.value).equalTo(value)
            where {
                componentAttribute.id isEqualTo id
            }
        }
        return findOneById(id)
    }

    override fun batchUpdateAttr(list: List<UpdateComponentAttributeDTO>): List<ComponentAttribute> {

        return list.stream()
            .map(Function<UpdateComponentAttributeDTO, ComponentAttribute> { dto: UpdateComponentAttributeDTO ->
                if (dto.attr != null && dto.value != null) {
                    updateByAttr(dto.attr, dto.value);
                    findOneByAttr(dto.attr)
                } else {
                    null
                }
            })
            .filter { it != null }
            .collect(Collectors.toList())
    }

    override fun remoteByAttr(ownerId: Long, attr: String): Boolean {
        return remoteByAttrs(ownerId, listOf(attr))
    }

    override fun remoteByAttrs(ownerId: Long, attrList: List<String>): Boolean {
         mapper!!.delete {
            where {
                componentAttribute.ownerId isEqualTo ownerId
                componentAttribute.attr isIn attrList
            }
        }
        return true;
    }

    override fun remoteById(id: Long): Boolean {
        return mapper!!.deleteByPrimaryKey(id) > 0
    }
}