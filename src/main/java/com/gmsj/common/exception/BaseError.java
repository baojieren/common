package com.gmsj.common.exception;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

import java.io.Serializable;

/**
 * 自定义异常处理
 *
 * @author renbaojie
 */
@Data
@Accessors(chain = true)
@NoArgsConstructor
public class BaseError implements Serializable {
    protected int code;
    protected String msg;
    public static final int SYS_ERR_CODE_START = 10000;

    public static final BaseError BAD_REQUEST = new BaseError(400, "请求错误");
    public static final BaseError AUTH_FAILED = new BaseError(401, "鉴权失败");
    public static final BaseError METHOD_NOT_ALLOWED = new BaseError(405, "请求方式错误");
    public static final BaseError SYS_ERR = new BaseError(SYS_ERR_CODE_START, "服务器异常");
    public static final BaseError DB_ERR = new BaseError(SYS_ERR_CODE_START + 1, "数据库异常");
    public static final BaseError PARAM_TYPE_ERR = new BaseError(SYS_ERR_CODE_START + 2, "参数类型错误");
    public static final BaseError PARAM_NOT_VALID = new BaseError(SYS_ERR_CODE_START + 3, "参数无效");

    public BaseError(String msg) {
        this.code = 500;
        this.msg = msg;
    }

    public BaseError(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }
}
