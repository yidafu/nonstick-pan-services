package dev.yidafu.pan.component.common.exception

enum class ExpectionCode(var code: Int, var message: String) {
    UnknownJsonValueType(100100111, "不支持的JSON基础数据类型"), IllegalComponentAttributeOwner(
        2001001000,
        "非法的属性所有者"
    )
}