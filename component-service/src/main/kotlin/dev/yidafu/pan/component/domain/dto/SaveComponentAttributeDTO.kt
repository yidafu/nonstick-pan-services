package dev.yidafu.pan.component.domain.dto

data class SaveComponentAttributeDTO(
    var ownerId: Long?,
    var attr: String?,
    var valueType: Byte?,
    var value: String?
)
