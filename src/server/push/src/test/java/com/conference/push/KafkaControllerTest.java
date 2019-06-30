package com.conference.push;

import com.conference.push.model.response.Message;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
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

//    @Test
//    public void kafkaTest() throws Exception {
//        Message message = new Message();
//        message.setMessage("helloWorld");
//        mockMvc.perform(post("/kafka/test", message))
//                .andExpect(status().isOk())
//                .andDo(print());
//    }
}
