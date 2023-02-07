package dev.yidafu.pan.component.service.impl

import dev.yidafu.pan.common.exception.attribute.ComponentAttributeCreateFialException
import dev.yidafu.pan.common.exception.attribute.IllegalComponentAttributeOwnerException
import dev.yidafu.pan.common.exception.attribute.NonexistentComponentAttributeException
import dev.yidafu.pan.common.json.JsonValue
import dev.yidafu.pan.common.model.dto.SaveComponentAttributeDTO
import dev.yidafu.pan.common.model.dto.UpdateComponentAttributeDTO
import dev.yidafu.pan.component.convertor.ComponentAttributeConvertor
import dev.yidafu.pan.component.domain.mapper.*
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
class ComponentAttributeServiceImpl : ComponentAttributeService {
    @Autowired
    var mapper: ComponentAttributeMapper? = null

    @Autowired
    var convertor: ComponentAttributeConvertor? = null

    val globelOwnerId = 0L

    override fun findOneById(id: Long): ComponentAttribute {
        return mapper?.selectOne{
            where {
                componentAttribute.id isEqualTo id
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

    /**
     * TODO: 缓存全局属性
     */
    override fun findAllByOwner(ownerId: Long): Map<String, JsonValue> {
        val attrList = mapper?.select {
            where {
                if (ownerId == globelOwnerId) {
                    componentAttribute.ownerId isEqualTo globelOwnerId
                } else {
                    componentAttribute.ownerId isIn  listOf<Long>(ownerId, globelOwnerId)
                }
            }
        } ?: Collections.emptyList();

        return attrList.associate { it.attr!! to JsonValue(it.valueType, it.value) };
    }

    override fun findAllByOwnerList(ownerIdList: List<Long>): Map<Long, Map<String, JsonValue>> {
        val globalAttr = findAllByOwner(globelOwnerId)

        val attrList = mapper?.select {
            where {
                componentAttribute.ownerId isIn ownerIdList
            }
        }
        val ownerMap = attrList
            ?.filter { it.ownerId != null && it.attr != null }
            ?.groupBy { it.ownerId!! }
            ?.mapValues {
                it.value.associate {it1 ->
                    it1.attr!! to JsonValue(it1.valueType, it1.value)
                }
            }  ?: emptyMap();

        return ownerIdList.associateWith {
            val fullMap = (
                    (ownerMap[it]?.asSequence() ?: emptySequence())
                            + globalAttr.asSequence()
                ).associate { it3 ->
                    it3.key to it3.value
                }

            fullMap
        }
    }
    override fun createOne(dto: SaveComponentAttributeDTO): ComponentAttribute {
        val componentAttribute: ComponentAttribute = convertor!!.from(dto)
        mapper?.insertSelective(componentAttribute)
        val id = componentAttribute.id;
        val attr = id?.let { findOneById(it)  }
        return attr ?: throw ComponentAttributeCreateFialException()
    }

    override fun batchCreate(list: List<SaveComponentAttributeDTO>): Map<String, JsonValue> {
        if (list.isEmpty()) return Collections.emptyMap();

        val ownerId: Long = list[0].ownerId ?: throw IllegalComponentAttributeOwnerException();

        val isTheSomeOwner = list.stream()
            .allMatch(Predicate<SaveComponentAttributeDTO> { attr: SaveComponentAttributeDTO -> attr.ownerId == ownerId })

        if (!isTheSomeOwner) {
            throw IllegalComponentAttributeOwnerException()
        }
        val attributeList: List<ComponentAttribute> = convertor!!.from(list).map() {
            it.createdAt = Date(); // insertMultiple 没有判断 createdAt,updatedAt 为空，需要手动赋值
            it.updatedAt = Date();
            it
        }
        mapper!!.insertMultiple(attributeList)
        return findAllByOwner(ownerId)
    }

    override fun updateByAttr(dto: UpdateComponentAttributeDTO): ComponentAttribute {
        if (null == dto.attr || null == dto.value || null == dto.valueType || null == dto.ownerId) {
            throw  IllegalArgumentException("Update Component Attribute data must not be null");
        }
        mapper!!.update {
            set(componentAttribute.value).equalTo(dto.value!!)
            where {
                componentAttribute.attr isEqualTo dto.attr!!
                componentAttribute.ownerId isEqualTo dto.ownerId!!
            }
        }

        return findOneByAttr(dto.attr!!)
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
        if (list.isEmpty()) return Collections.emptyList();

        return list.stream()
            .map(Function<UpdateComponentAttributeDTO, ComponentAttribute> { dto: UpdateComponentAttributeDTO ->
                if (dto.attr != null && dto.value != null) {
                    updateByAttr(dto);
                    findOneByAttr(dto.attr!!)
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
        if (attrList.isEmpty()) return true
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