package com.gmsj.common.dto;

import com.gmsj.common.exception.BaseError;
import lombok.Getter;

import java.io.Serializable;

/**
 * 统一响应结果实体类
 *
 * @author renbaojie
 */
@Getter
public class BaseOutDTO implements Serializable {
    private Integer code;
    private String msg;
    private Object data;

    public BaseOutDTO() {
        this.code = 200;
        this.msg = "ok";
        this.data = null;
    }

    public BaseOutDTO setData(Object data) {
        this.data = data;
        return this;
    }

    public BaseOutDTO fail(String msg) {
        this.code = 500;
        this.msg = msg;
        return this;
    }

    public BaseOutDTO fail(int code, String msg) {
        this.code = code;
        this.msg = msg;
        return this;
    }

    public BaseOutDTO fail(BaseError baseError) {
        this.code = baseError.getCode();
        this.msg = baseError.getMsg();
        return this;
    }

    @Override
    public String toString() {
        return "BaseOutDTO{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }
}
