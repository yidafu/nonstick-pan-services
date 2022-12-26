package dev.yidafu.pan.component.convertor

import dev.yidafu.pan.component.domain.dto.SaveComponentDTO
import dev.yidafu.pan.component.domain.dto.UpdateComponentDTO
import dev.yidafu.pan.component.domain.model.Component
import dev.yidafu.pan.component.domain.vo.ComponentVO
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper
import org.mapstruct.factory.Mappers

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface ComponentConvertor {
    fun to(list: List<Component>): List<ComponentVO>
    fun to(com: Component): ComponentVO
    fun from(dto: SaveComponentDTO): Component
    fun from(dto: UpdateComponentDTO): Component

    companion object {
        val INSTANCE: ComponentConvertor = Mappers.getMapper(ComponentConvertor::class.java)
    }
}