package dev.yidafu.pan.component.common.exception

enum class ExpectionCode(var code: Int, var message: String) {
    UnknownJsonValueType(100100111, "不支持的JSON基础数据类型"),
    IllegalComponentAttributeOwner(
        2001001000,
        "非法的属性所有者"
    ),

    NonexistentComponent(100200111, "组件不存在"),
    ComponentCreateFail(100200112, "组件创建失败"),

    NonexistentComponentAttribute(100300111, "组件属性不存在"),
    CreateComponentAttributeFail(100300112, "创建组件属性失败"),


    ;
}