package dev.yidafu.pan.common.exception

import dev.yidafu.kotlin.api.common.IErrorCode

enum class ExceptionCode(override var code: Int, override var message: String): IErrorCode {
    UnknownJsonValueType(100100111, "不支持的JSON基础数据类型"),
    IllegalComponentAttributeOwner(
        2001001000,
        "非法的属性所有者"
    ),

    NonexistentComponent(100200111, "组件不存在"),
    ComponentCreateFail(100200112, "组件创建失败"),

    NonexistentComponentAttribute(100300111, "组件属性不存在"),
    CreateComponentAttributeFail(100300112, "创建组件属性失败"),

    NonexistentScreen(100400100, "大屏不存在"),
    CreateScreenFail(100400101, "创建大屏失败"),
    ScreenNoComponent(100400102, "大屏没有改组件")

    ;
}