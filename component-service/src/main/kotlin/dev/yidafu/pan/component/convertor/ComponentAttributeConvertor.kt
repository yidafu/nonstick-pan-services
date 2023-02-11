package dev.yidafu.pan.component.convertor

import dev.yidafu.pan.common.json.JsonValue
import dev.yidafu.pan.common.model.dto.SaveComponentAttributeDTO
import dev.yidafu.pan.common.model.dto.UpdateComponentAttributeDTO
import dev.yidafu.pan.component.domain.model.ComponentAttribute
import org.mapstruct.InjectionStrategy
import org.mapstruct.Mapper

@Mapper(componentModel = "spring", injectionStrategy = InjectionStrategy.CONSTRUCTOR)
interface ComponentAttributeConvertor {

    fun from(list: List<SaveComponentAttributeDTO>): List<ComponentAttribute>

    fun from(list: SaveComponentAttributeDTO): ComponentAttribute

    companion object {
        fun to(ownerId: Long, map: Map<String, JsonValue>): List<SaveComponentAttributeDTO> {
            return map.map {
                SaveComponentAttributeDTO(
                    ownerId,
                    it.key,
                    it.value.valueType?.value,
                    it.value.value
                )
            }.toList()
        }
        //
        fun toUpdateDTOList(ownerId: Long, map: Map<String, JsonValue>): List<UpdateComponentAttributeDTO> {
            return map.map {
                UpdateComponentAttributeDTO(
                    ownerId,
                    it.key,
                    it.value.valueType?.value,
                    it.value.value
                )
            }.toList()
        }
    }
}
