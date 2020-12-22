package com.dao;

import com.pojo.User;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Repository;

/**
 * @author TanHaooo
 * @date 2020/12/20 19:02
 */
@Repository("useDao")
@Mapper
public interface UserDao {

    /**
     * 根据姓名查询用户
     *
     * @param name 姓名
     * @return
     */
    User selectByName(String name);

}
