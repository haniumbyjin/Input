package com.confrence.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
class FileControllerTest {
    @Autowired
    private FileController filecontroller;
    private MockMvc mockMvc;

    @Test
    void mockTest() throws Exception{
        mockMvc = MockMvcBuilders.standaloneSetup(filecontroller).build();
        mockMvc.perform(
                MockMvcRequestBuilders.get("/upload")
        ).andDo(MockMvcResultHandlers.print())
         .andExpect(MockMvcResultMatchers.status().isOk());
    }

}