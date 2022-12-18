package dev.yidafu.pan.component.common.exception;

public enum ExpectionCode {
    UnknownJsonValueType(100100111, "不支持的JSON基础数据类型"),
    IllegalComponentAttributeOwner(2001001000, "非法的属性所有者")
    ;

    int code;
    String message;


    ExpectionCode(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
