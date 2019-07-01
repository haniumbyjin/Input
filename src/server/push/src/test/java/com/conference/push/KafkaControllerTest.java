package com.conference.push;

import com.conference.push.model.response.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class KafkaControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void kafkaTest() throws Exception {

        mockMvc.perform(post("/kafka/test")
                .content("{\n" +
                        "\t\"message\" : \"hi\"\n" +
                        "}")
                .contentType(MediaType.APPLICATION_JSON_UTF8)) // content의 type을 명시합니다.
                .andExpect(status().isOk())
                .andDo(print());
    }
}
