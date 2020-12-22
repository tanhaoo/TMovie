package com.controller;

import com.common.utils.GeeTestLib;
import com.pojo.BaseResult;
import com.pojo.UserLogin;
import com.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author TanHaooo
 * @date 2020/11/28 18:57
 */
@RestController
@Api("用户服务接口")
@RequestMapping("member")
public class UserController {
    @Autowired
    private UserService userService;

    /**
     * GeeTest初始化
     *
     * @param request
     * @return
     */
    @ApiOperation(value = "GeeTest初始化")
    @GetMapping("geeTestInit")
    public String geeTestInit(HttpServletRequest request) {
        GeeTestLib gtSdk = new GeeTestLib(GeeTestLib.id, GeeTestLib.key, GeeTestLib.newfailback);
        String resStr = "{}";
        //自定义参数,可选择添加
        HashMap<String, String> param = new HashMap<String, String>();
        // 进行验证预处理
        int getServerStatus = gtSdk.preProcess(param);
        resStr = gtSdk.getResponseStr();
        return resStr;
    }

    /**
     * 用户登录
     *
     * @param userLogin 用户登录信息
     * @return
     */
    @PostMapping("login")
    @ApiOperation(value = "用户登录")
    public BaseResult login(@RequestBody UserLogin userLogin, HttpSession session) {
        BaseResult baseResult = userService.login(userLogin, session);
        return baseResult;
    }
}
