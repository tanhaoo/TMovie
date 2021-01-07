package com.pojo;

import lombok.Data;

import java.util.Date;

/**
 * @author TanHaooo
 * @date 2020/12/20 19:15
 */
@Data
public class User {

    /**
     * 用户id
     */
    private int user_id;
    /**
     * 用户姓名
     */
    private String user_name;
    /**
     * 用户密码
     */
    private String password;
    /**
     * 用户手机号
     */
    private String phone;
    /**
     * 用户性别
     */
    private String sex;
    /**
     * 用户头像
     */
    private String img;
    /**
     * 用户注册时间
     */
    private Date created;
    /**
     * 用户更新时间
     */
    private Date updated;

}
