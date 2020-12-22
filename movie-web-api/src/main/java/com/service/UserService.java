package com.service;

import com.pojo.BaseResult;
import com.pojo.UserLogin;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpSession;

/**
 * @author TanHaooo
 * @date 2020/12/21 15:36
 */
public interface UserService {
    /**
     * 会员登录
     *
     * @param memberLogin 会员登录信息
     * @param session 会话信息
     * @return
     */
    BaseResult login(UserLogin memberLogin, HttpSession session);

}
