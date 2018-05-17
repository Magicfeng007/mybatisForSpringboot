package com.magic.springboot;

import com.alibaba.fastjson.JSONObject;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

/**
 * @Author: Magicfeng007
 * @Description:
 * @Date: Created in 2018-05-14---下午7:26
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@WebAppConfiguration//开启web上下文测试
public class SrpingbootMybatisWebTest {
    private final Logger logger = LoggerFactory.getLogger(SrpingbootMybatisWebTest.class);
    @Autowired
    private WebApplicationContext webApplicationContext;

    private MockMvc mockMvc;


    //设置mockMvc
    @Before
    public void setMockMvc(){
        mockMvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
    }

    @Test
    public void findUser(){
        try {
            mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,"/userList")
                    .contentType(MediaType.APPLICATION_JSON)
                    .param("userId","1")
            )
            .andExpect(MockMvcResultMatchers.status().isOk())
            .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAllUsers(){
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("userId","1");
        try {
            mockMvc.perform(MockMvcRequestBuilders.request(HttpMethod.POST,"/showAllUsers")
                    .contentType(MediaType.APPLICATION_JSON)
                    //.content(jsonObject.toJSONString())
                    //.param("userId","12")
            )
                    .andExpect(MockMvcResultMatchers.status().isOk())
                    .andDo(MockMvcResultHandlers.print());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
