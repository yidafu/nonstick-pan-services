package dev.yidafu.pan.common.model.vo

class PageVO<T>(var data: T, var page: Long = 1, var size: Long = -1, var total: Long) {
}