package dev.yidafu.pan.component.convertor

import dev.yidafu.pan.component.common.json.JsonValue
import dev.yidafu.pan.component.domain.bo.ComponentAttributeBO
import dev.yidafu.pan.component.domain.dto.SaveComponentAttributeDTO
import dev.yidafu.pan.component.domain.dto.UpdateComponentAttributeDTO
import dev.yidafu.pan.component.domain.model.ComponentAttribute
import org.mapstruct.Mapper
import java.util.Collections
import java.util.stream.Collectors

@Mapper(componentModel = "spring")
interface ComponentAttributeConvertor {
    fun from(list: List<SaveComponentAttributeDTO>): List<ComponentAttribute>
    fun from(list: SaveComponentAttributeDTO): ComponentAttribute

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