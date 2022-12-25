package dev.yidafu.pan.component.domain.model

import java.util.Date

data class ComponentRecord(
    var id: Long? = null,
    var screenId: Long? = null,
    var groupId: Long? = null,
    var name: String? = null,
    var layerName: String? = null,
    var isGroup: Byte? = null,
    var width: Int? = null,
    var height: Int? = null,
    var offsetX: Int? = null,
    var offsetY: Int? = null,
    var zIndex: Int? = null,
    var isLock: Byte? = null,
    var isLockAspectRatio: Byte? = null,
    var category: String? = null,
    var subCategory: String? = null,
    var umdJsUrl: String? = null,
    var createdAt: Date? = null,
    var updatedAt: Date? = null,
    var styleLabelConfig: String? = null,
    var styleConfig: String? = null,
    var requestConfig: String? = null,
    var interactConfig: String? = null
)