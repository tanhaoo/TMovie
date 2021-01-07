package com.service;

import com.pojo.Movie;
import com.pojo.PageSetting;

import java.util.List;

/**
 * @author TanHaooo
 * @date 2020/12/23 16:25
 */
public interface MovieService {

    /**
     * 查询分页电影
     *
     * @param pageSetting 分页信息
     * @return
     */
    List<Movie> getPageMovie(PageSetting pageSetting) ;

}
