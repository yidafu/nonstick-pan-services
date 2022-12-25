//package dev.yidafu.pan.component.convertor
//
//import dev.yidafu.pan.component.domain.entity.Component
//import org.mapstruct.Mapper
//
//@Mapper(componentModel = "spring")
//interface ComponentConvertor {
//    fun to(list: List<Component?>?): List<ComponentVO?>?
//    fun to(com: Component?): ComponentVO?
//    fun from(dto: SaveComponentDTO?): Component?
//    fun from(dto: UpdateComponentDTO?): Component?
//
//    companion object {
//        val INSTANCE: ComponentConvertor = Mappers.getMapper(ComponentConvertor::class.java)
//    }
//}