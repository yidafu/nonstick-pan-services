package dev.yidafu.pan.screen.domain.model

import java.io.Serializable
import java.util.Date

data class Screen(
    var id: Long? = null,
    var name: String? = null,
    var width: Int? = null,
    var height: Int? = null,
    var backgroundColor: String? = null,
    var backgroundImage: String? = null,
    var snapshotUrl: String? = null,
    var fillType: Byte? = null,
    var isPublished: Byte? = null,
    var isTemplate: Byte? = null,
    var createdAt: Date? = null,
    var updatedAt: Date? = null
) : Serializable