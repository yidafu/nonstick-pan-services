package dev.yidafu.pan.component.convertor

import dev.yidafu.pan.component.domain.dto.SaveComponentAttributeDTO
import dev.yidafu.pan.component.domain.model.ComponentAttribute
import org.mapstruct.Mapper

@Mapper(componentModel = "spring")
interface ComponentAttributeConvertor {
    fun from(list: List<SaveComponentAttributeDTO>): List<ComponentAttribute>
    fun from(list: SaveComponentAttributeDTO): ComponentAttribute
}