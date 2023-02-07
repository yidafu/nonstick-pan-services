package dev.yidafu.pan.common.model.dto

import com.fasterxml.jackson.databind.JsonNode


open class BaseComponentDTO {
    val screenId: Long? = null
    val groupId: Long? = null
    val name: String? = null
    val layerName: String? = null
    val isGroup: Byte? = null
    val width: Int? = null
    val height: Int? = null
    val offsetX: Int? = null
    val offsetY: Int? = null
    val zIndex: Int? = null
    val isLock: Byte? = null
    val isLockAspectRatio: Byte? = null
    val category: String? = null
    val subCategory: String? = null
    val umdJsUrl: String? = null
    val styleLabelConfig: JsonNode? =null
    val styleConfig: JsonNode? = null
    val requestConfig: JsonNode? = null
    val interactConfig: JsonNode? = null
}