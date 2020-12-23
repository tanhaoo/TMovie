package com.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.pojo.BaseResult;
import com.pojo.Movie;
import com.pojo.PageSetting;
import com.pojo.UserLogin;

import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @author TanHaooo
 * @date 2020/12/23 16:25
 */
public interface MovieService {

    /**
     * 查询所有电影
     *
     * @param pageSetting 会员登录信息
     * @return
     */
    List<Movie> getAllMovie(PageSetting pageSetting) ;

}
