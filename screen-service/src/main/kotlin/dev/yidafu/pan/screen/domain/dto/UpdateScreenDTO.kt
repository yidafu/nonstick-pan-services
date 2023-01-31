package dev.yidafu.pan.screen.domain.dto

import java.io.Serializable

class UpdateScreenDTO: Serializable {
    var id: Long? = null
    var name: String? = null
    var width: Int? = null
    var height: Int? = null
    var backgroundColor: String? = null
    var backgroundImage: String? = null
    var snapshotUrl: String? = null
    var fillType: Byte? = null
    var isPublished: Byte? = null
    var isTemplate: Byte? = null
}