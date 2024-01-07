package com.example.rensyu03.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(UserInfoController.class)
@AutoConfigureMockMvc
public class UserInfoControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testGetUserInfo() throws Exception {

        this.mockMvc.perform(get("/myapi/userinfo"))
                .andExpect(status().isOk())
                .andExpect(content().string("User information"));
    }
}