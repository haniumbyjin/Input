package com.conference.chatting.service;

import com.conference.chatting.model.request.TestReq;
import com.conference.chatting.model.response.TestRes;

public interface TestService {

    TestRes test(String testParam);

    TestRes test(TestReq testReq, String testHeader);

}
