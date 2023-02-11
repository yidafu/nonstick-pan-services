package dev.yidafu.pan.component.domain.model

import java.util.Date

data class ComponentAttributeRecord(
    var id: Long? = null,
    var ownerId: Long? = null,
    var attr: String? = null,
    var valueType: Byte? = null,
    var value: String? = null,
    var createdAt: Date? = null,
    var updatedAt: Date? = null
)
