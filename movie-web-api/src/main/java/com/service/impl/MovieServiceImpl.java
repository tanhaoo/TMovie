package com.service.impl;

import com.dao.MovieDao;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.pojo.Movie;
import com.pojo.PageSetting;
import com.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author TanHaooo
 * @date 2020/12/23 16:25
 */
@Service
public class MovieServiceImpl implements MovieService {
    @Autowired
    public MovieDao movieeDao;

    @Override
    public List<Movie> getAllMovie(PageSetting pageSetting) {
        Page page=PageHelper.startPage(pageSetting.getPageNum(), pageSetting.getPageSize());
        List<Movie> movies = movieeDao.selectAllMovie();
        PageInfo pageInfo = new PageInfo(movies);

        return pageInfo.getList();
    }
}
