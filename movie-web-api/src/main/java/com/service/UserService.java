package com.service;

import com.pojo.BaseResult;
import com.pojo.User;
import com.pojo.UserLogin;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author TanHaooo
 * @date 2020/12/21 15:36
 */
public interface UserService {
    /**
     * 用户登录
     *
     * @param memberLogin 用户登录信息
     * @param session 会话信息
     * @return
     */
    BaseResult login(UserLogin memberLogin, HttpSession session);


    /**
     * 用户修改姓名
     *
     * @param memberLogin 用户登录信息
     * @return
     */
    BaseResult updateName(UserLogin memberLogin);


    /**
     * 用户注册
     *
     * @param user 用户信息
     * @return
     */
    BaseResult register(User user);
}
