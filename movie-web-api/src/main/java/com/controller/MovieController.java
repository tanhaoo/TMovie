package com.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.github.pagehelper.PageHelper;
import com.pojo.Movie;
import com.pojo.PageSetting;
import com.service.MovieService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author TanHaooo
 * @date 2020/12/23 16:28
 */
@RestController
@Api("电影服务接口")
@RequestMapping("movie")
public class MovieController {

    @Autowired
    private MovieService movieService;

    /**
     * 获取分页影片
     *
     * @param
     */
    @ApiOperation("获取分页影片信息")
    @PostMapping("getPageMovie")
    public List<Movie> getPageMovie(@RequestBody PageSetting pageSetting) {
        List<Movie> movieList = movieService.getPageMovie(pageSetting);
        return movieList;
    }

}
