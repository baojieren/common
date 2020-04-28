package com.gmsj.common.constant;

import java.io.Serializable;

/**
 * @author baojieren
 * @date 2020/4/20 18:09
 */
public enum SignInTypeEnum implements Serializable {
    WX(0, "微信"),
    PHONE(1, "手机");

    public int key;
    public String value;

    SignInTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }
}
