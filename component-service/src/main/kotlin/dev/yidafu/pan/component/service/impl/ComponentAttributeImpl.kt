//package dev.yidafu.pan.component.service.impl
//
//import dev.yidafu.pan.component.convertor.ComponentAttributeConvertor
//import dev.yidafu.pan.component.domain.dao.ComponentAttributeDynamicSqlSupport
//import dev.yidafu.pan.component.domain.dao.ComponentAttributeMapper
//import dev.yidafu.pan.component.domain.entity.ComponentAttribute
//import dev.yidafu.pan.component.service.ComponentAttributeService
//import org.mybatis.dynamic.sql.SqlBuilder.isEqualTo
//import org.springframework.beans.factory.annotation.Autowired
//import org.springframework.stereotype.Service
//import java.util.function.Function
//import java.util.function.Predicate
//
//@Service
//class ComponentAttributeImpl : ComponentAttributeService {
//    @Autowired
//    var mapper: ComponentAttributeMapper? = null
//
//    @Autowired
//    var convertor: ComponentAttributeConvertor? = null
//    override fun findOneById(id: Long?): ComponentAttribute {
//        val completer = SelectDSLCompleter { c ->
//            c
//                .where()
//                .and(ComponentAttributeDynamicSqlSupport.id, isEqualTo(id))
//        }
//        return mapper.selectOne(completer).orElse(null)
//    }
//
//    override fun findOneByAttr(attr: String?): ComponentAttribute {
//        val completer = SelectDSLCompleter { c ->
//            c
//                .where()
//                .and(ComponentAttributeDynamicSqlSupport.attr, isEqualTo(attr))
//        }
//        return mapper.selectOne(completer).orElse(null)
//    }
//
//    override fun findAllByOwner(ownerId: Long?): List<ComponentAttribute> {
//        val completer = SelectDSLCompleter { c ->
//            c
//                .where()
//                .and(ComponentAttributeDynamicSqlSupport.ownerId, isEqualTo(ownerId))
//        }
//        return mapper.select(completer)
//    }
//
//    override fun createOne(dto: SaveComponentAttributeDTO?): ComponentAttribute {
//        val componentAttribute: ComponentAttribute = convertor.from(dto)
//        mapper.insert(componentAttribute)
//        return findOneById(componentAttribute.id)
//    }
//
//    override fun batchCreate(list: List<SaveComponentAttributeDTO>): List<ComponentAttribute> {
//        val ownerId: Long = list[0].getOwnerId()
//        val isTheSomeOwner = list.stream()
//            .allMatch(Predicate<SaveComponentAttributeDTO> { attr: SaveComponentAttributeDTO -> attr.getOwnerId() == ownerId })
//        if (!isTheSomeOwner) {
//            throw IllegalComponentAttributeOwnerException()
//        }
//        val attributeList: List<ComponentAttribute> = convertor.from(list)
//        mapper.insertMultiple(attributeList)
//        return findAllByOwner(ownerId)
//    }
//
//    override fun updateByAttr(attr: String?, value: String?): ComponentAttribute {
//        val completer = UpdateDSLCompleter { c ->
//            c
//                .set(ComponentAttributeDynamicSqlSupport.value).equalTo(value)
//                .where()
//                .and(ComponentAttributeDynamicSqlSupport.attr, isEqualTo(attr))
//        }
//        mapper.update(completer)
//        return findOneByAttr(attr)
//    }
//
//    override fun updateById(id: Long?, value: String?): ComponentAttribute {
//        val completer = UpdateDSLCompleter { c ->
//            c
//                .set(ComponentAttributeDynamicSqlSupport.value).equalTo(value)
//                .where()
//                .and(ComponentAttributeDynamicSqlSupport.id, isEqualTo(id))
//        }
//        mapper.update(completer)
//        return findOneById(id)
//    }
//
//    override fun batchUpdateAttr(list: List<UpdateComponentAttributeDTO>): List<ComponentAttribute> {
//        return list.stream()
//            .map(Function<UpdateComponentAttributeDTO, ComponentAttribute> { dto: UpdateComponentAttributeDTO ->
//                updateByAttr(dto.getAttr(), dto.getValue())
//                findOneByAttr(dto.getAttr())
//            }).collect(Collectors.toList<ComponentAttribute>())
//    }
//
//    override fun remoteByAttr(ownerId: Long?, attr: String): Boolean {
//        return remoteByAttrs(ownerId, listOf(attr))
//    }
//
//    override fun remoteByAttrs(ownerId: Long?, attrList: List<String?>?): Boolean {
//        val completer = DeleteDSLCompleter { c ->
//            c
//                .where()
//                .and(ComponentAttributeDynamicSqlSupport.ownerId, isEqualTo(ownerId))
//                .and(ComponentAttributeDynamicSqlSupport.attr, SqlBuilder.isIn(attrList))
//        }
//        return mapper.delete(completer) > 0
//    }
//
//    override fun remoteById(id: Long?): Boolean {
//        return mapper.deleteByPrimaryKey(id) > 0
//    }
//}