package com.gmsj.common.model;

import lombok.Data;

import java.io.Serializable;

/**
 * 用户基础信息
 *
 * @author baojieren
 * @date 2020/4/16 13:41
 */
@Data
public class UserInfo implements Serializable {

    /**
     * 用户id
     */
    public Integer id;

    /**
     * 用户名
     */
    public String userName;

    /**
     * 用户手机号
     */
    public String phone;

    /**
     * 头像
     */
    public String logo;

    /**
     * 微信openId
     */
    public String openId;

    /**
     * 公司id
     */
    public Integer companyId;

    /**
     * 公司名称
     */
    public String companyName;

    /**
     * 职务
     */
    public String job;

    /**
     * 详细地址
     */
    public String addr;

    /**
     * 邮箱
     */
    public String email;

    /**
     * 个人描述
     */
    public String remark;
}