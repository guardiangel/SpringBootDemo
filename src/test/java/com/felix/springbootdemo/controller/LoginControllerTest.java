package com.felix.springbootdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.felix.springbootdemo.entity.SysUser;
import jakarta.annotation.Resource;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import java.util.Base64;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
class LoginControllerTest {
    private MockMvc mockMvc;
    @Resource
    private WebApplicationContext webApplicationContext;

    @BeforeEach
    public void setup() throws Exception {
        this.mockMvc = MockMvcBuilders
                .webAppContextSetup(this.webApplicationContext).build();
    }
    @Test
    void getLoginImgCode() {

        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                            .get("/login/getLoginImgCode/1111")
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn();

            System.err.println(mvcResult.getResponse().getContentAsString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    void login() {

        ObjectMapper objectMapper = new ObjectMapper();

        String imageCode = "data:image/png;base64,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";

        String str = null;
        try {
            SysUser user = new SysUser();
            user.setLoginName("admin");
            user.setPassword("123456");
            user.setImageCode("9245");
            user.setUuid("1111");
            str = objectMapper.writeValueAsString(user);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        try {
            MvcResult mvcResult = mockMvc.perform(MockMvcRequestBuilders
                            .post("/login/login")
                            .content(str)
                            .contentType(MediaType.APPLICATION_JSON)
                            .accept(MediaType.APPLICATION_JSON))
                    .andExpect(status().isOk()).andReturn();

            System.err.println(mvcResult.getResponse().getContentAsString());

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}