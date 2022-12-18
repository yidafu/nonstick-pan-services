package dev.yidafu.pan.component.common.exception;

import lombok.Data;

@Data
public class ServiceException extends RuntimeException {
    int code;

    String message;

    public ServiceException(String message) {
        super(message);
        this.message = message;
        code = 9999;
    }

    public ServiceException(int code, String message) {
        super(message);
        this.message = message;
        this.code = code;
    }

    public ServiceException(ExpectionCode code) {
        super(code.message);
        this.code = code.code;
        this.message = code.message;
    }
}
