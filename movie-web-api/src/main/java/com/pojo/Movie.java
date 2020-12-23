package com.pojo;

import lombok.Data;

/**
 * @author TanHaooo
 * @date 2020/12/23 15:56
 */
@Data
public class Movie {
    /**
     * 电影id
     */
    private int movie_id;
    /**
     * 电影名称
     */
    private String movie_name;
    /**
     * 电影图片RUL
     */
    private String url;
    /**
     * 电影时长    |
     */
    private String timer;
    /**
     * 电影类型
     */
    private String genre;
    /**
     * 电影上映时间
     */
    private String release_time;
    /**
     * 电影简介
     */
    private String introduce;
    /**
     * 电影导演
     */
    private String directors;
    /**
     * 电影编剧    |
     */
    private String writers;
    /**
     * 电影明星    |
     */
    private String stars;
}
