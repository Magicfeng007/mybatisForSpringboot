package com.magic.springboot.controller;

import com.magic.springboot.mapper.UserMapper;
import com.magic.springboot.model.User;
import org.apache.commons.collections.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @Author: Magicfeng007
 * @Description:
 * @Date: Created in 2018-05-13---下午9:36
 */
@Controller
public class UserController {

    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserMapper userMapper;

    @RequestMapping("/userList")
    @ResponseBody
    public String findUserById(User user){
        User userInfo = userMapper.selectByPrimaryKey(user);
        return userInfo == null ? "查无记录" : userInfo.toString();
    }

    @RequestMapping("/showAllUsers")
    @ResponseBody
    public String showAllUsers(){
        List<User> userList = userMapper.findAll();
        String userInfo = "";
        if(!CollectionUtils.isEmpty(userList)){
            for (User user : userList) {
                userInfo += user.toString();
            }
        }
        return "".equals(userInfo)?"查无记录":userInfo;
    }

    @RequestMapping("/addUser")
    @ResponseBody
    public String addUser(User user){
        return  Integer.toString(userMapper.insert(user));//经测试成功时返回1
    }
}
