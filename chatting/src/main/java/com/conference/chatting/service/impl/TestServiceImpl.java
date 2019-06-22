package com.conference.chatting.service.impl;

import com.conference.chatting.model.request.TestReq;
import com.conference.chatting.model.response.TestRes;
import com.conference.chatting.model.wrapper.ResponseWrapper;
import com.conference.chatting.service.TestService;
import org.springframework.stereotype.Service;

@Service
public class TestServiceImpl implements TestService {

    @Override
    public TestRes test(String testParam) {

        TestRes result = TestRes.builder()
                .data("data")
                .build();

        return result;

    }

    @Override
    public TestRes test(TestReq testReq, String testHeader) {

        TestRes result = TestRes.builder()
                .data("data")
                .build();

        return result;

    }
}
