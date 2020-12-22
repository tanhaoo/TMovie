package com.service.impl;

import com.dao.UserDao;
import com.pojo.BaseResult;
import com.pojo.User;
import com.pojo.UserLogin;
import com.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import javax.servlet.http.HttpSession;

/**
 * @author TanHaooo
 * @date 2020/12/21 15:53
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    public UserDao useDao;

    @Override
    public BaseResult login(UserLogin userLogin, HttpSession session) {
        String account = userLogin.getAccount();
        User user = useDao.selectByName(account);
        return md5Login(userLogin, user, session);
    }

    private BaseResult md5Login(UserLogin userLogin, User user, HttpSession session) {
        String md5Password = DigestUtils.md5DigestAsHex(userLogin.getPassword().getBytes());
        if (user != null && user.getPassword().equals(md5Password)) {
            return BaseResult.success(user);
        } else {
            return BaseResult.fail("账号或密码错误");
        }
    }
}
