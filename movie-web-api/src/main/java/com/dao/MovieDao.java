package com.dao;


import com.pojo.Movie;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author TanHaooo
 * @date 2020/12/23 16:04
 */
@Repository("movieeDao")
@Mapper
public interface MovieDao {

    /**
     * 查询分页电影
     *
     * @return
     */
    List<Movie> selectAllMovie();
}
