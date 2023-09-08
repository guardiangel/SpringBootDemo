package com.felix.springbootdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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

        ObjectMapper objectMapper = new ObjectMapper();

        String str = null;
        try {
            str = objectMapper.writeValueAsString("1111");
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
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
}