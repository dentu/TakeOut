package com.takeout.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.io.Serializable;

/**
 * (User)实体类
 *
 * @author makejava
 * @since 2022-05-27 15:14:06
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User implements Serializable {
    private static final long serialVersionUID = 510341978124100603L;
    /**
     * 编号
     */
    private Integer id;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 帐号
     */
    private String account;
    /**
     * 密码
     */
    private String password;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 手机
     */
    private String phone;
    /**
     * 出生时间
     */
    private Date age;
    /**
     * 头像
     */
    private String headImg;
    /**
     * 性别
     */
    private String sex;
    /**
     * 状态
     */
    private Integer status;
    /**
     * 创建时间
     */
    private Date createDate;

}

