package dev.yidafu.pan.common.model.dto

import com.fasterxml.jackson.databind.JsonNode
import java.io.Serializable

open class BaseComponentDTO : Serializable {
    var screenId: Long? = null
    var groupId: Long? = null
    var name: String? = null
    var layerName: String? = null
    var isGroup: Byte? = null
    var width: Int? = null
    var height: Int? = null
    var offsetX: Int? = null
    var offsetY: Int? = null
    var zIndex: Int? = null
    var isLock: Byte? = null
    var isLockAspectRatio: Byte? = null
    var category: String? = null
    var subCategory: String? = null
    var umdJsUrl: String? = null
    var styleLabelConfig: JsonNode? = null
    var styleConfig: JsonNode? = null
    var requestConfig: JsonNode? = null
    var interactConfig: JsonNode? = null
}
