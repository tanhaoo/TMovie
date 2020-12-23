package com.pojo;

import lombok.Data;

/**
 * @author TanHaooo
 * @date 2020/12/23 16:34
 */
@Data
public class PageSetting {
    /**
     * 显示第几页
     */
    private int pageNum;
    /**
     * 显示一页多少条
     */
    private int pageSize;
}
