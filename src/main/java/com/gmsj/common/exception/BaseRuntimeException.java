package com.gmsj.common.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 自定义异常处理
 *
 * @author renbaojie
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class BaseRuntimeException extends RuntimeException {
    public int code;

    public BaseRuntimeException(int code, String msg) {
        super(msg);
        this.code = code;
    }

    public BaseRuntimeException(BaseError error) {
        super(error.getMsg());
        this.code = error.getCode();
    }
}
