package org.shenlan.web;

import org.apache.ibatis.annotations.*;

/**
 * Created by Administrator on 2016/9/2.
 */
@Mapper
public interface UserMapper {

    @Results({
            @Result(property = "name",column = "name"),
            @Result(property = "age",column = "age")
    })
    @Select("select * from user where name = #{name}")
    User findUserByName(@Param("name")String name);
}
