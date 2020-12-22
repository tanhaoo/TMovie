package com.pojo;

import lombok.Data;

/**
 * @author TanHaooo
 * @date 2020/12/20 17:48
 */
@Data
public class UserLogin {

    /**
     * 账号
     */
    private String account;

    /**
     * 邮箱
     */
    private String password;

    /**
     * 是否自动登录，否 账号信息存 session， 是 账号信息存 Redis Session
     */
    private Boolean auto;
}
