package com.magic.springboot.mapper;

import com.github.abel533.mapper.Mapper;
import com.magic.springboot.model.User;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author: Magicfeng007
 * @Description:
 * @Date: Created in 2018-05-17---下午7:39
 */
public interface UserMapper extends Mapper<User>{

    @Select("select * from t_user")
    List<User> findAll();

}
