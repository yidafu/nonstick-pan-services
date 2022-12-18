package dev.yidafu.pan.component.common.exception;

public class UnknownJsonValueTypeException extends ServiceException {
    public UnknownJsonValueTypeException() {
        super(ExpectionCode.UnknownJsonValueType);
    }
}
