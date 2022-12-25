//package dev.yidafu.pan.component.service.impl
//
//import dev.yidafu.pan.component.domain.entity.Component
//import org.mybatis.dynamic.sql.select.SelectDSLCompleter
//import org.springframework.stereotype.Service
//import java.util.*
//import java.util.function.Function
//
//@Service
//class ComponentServiceImpl : ComponentService {
//    @Autowired
//    var componentMapper: ComponentMapper? = null
//
//    @Autowired
//    var convertor: ComponentConvertor? = null
//    override fun findById(id: Long?): ComponentVO {
//        val completer = SelectDSLCompleter { c -> c.where().and(ComponentDynamicSqlSupport.id, isEqualTo(id)) }
//        val optCom: Optional<Component> = componentMapper.selectOne(completer)
//        return optCom.map<ComponentVO>(Function<Component, ComponentVO> { component: Component? ->
//            convertor.to(
//                component
//            )
//        }).orElse(null)
//    }
//
//    override fun findAllByScreenId(screenId: Long?): List<ComponentVO?> {
//        val completer =
//            SelectDSLCompleter { c -> c.where().and(ComponentDynamicSqlSupport.screenId, isEqualTo(screenId)) }
//        val componentList: List<Component> = componentMapper.select(completer)
//        return convertor.to(componentList)
//    }
//
//    override fun updateById(id: Long?, dto: UpdateComponentDTO?): ComponentVO {
//        val component: Component = convertor.from(dto)
//        component.id = id
//        componentMapper.updateByPrimaryKey(component)
//        return findById(id)
//    }
//
//    override fun createOne(dto: SaveComponentDTO?): ComponentVO {
//        val component: Component = convertor.from(dto)
//        componentMapper.insert(component)
//        return findById(component.id)
//    }
//}