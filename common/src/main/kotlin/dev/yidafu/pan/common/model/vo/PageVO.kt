package dev.yidafu.pan.common.model.vo

import java.io.Serializable

class PageVO<T>(
    var data: T,
    var page: Long = 1,
    var size: Long = -1,
    var total: Long,
): Serializable {}