package com.conference.chatting.advice;

import com.conference.chatting.model.wrapper.ResponseWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

import java.util.Locale;

@ControllerAdvice(basePackages = "com.conference.chatting")
public class ResMessageAdvice implements ResponseBodyAdvice<ResponseWrapper> {

    @Autowired
    private MessageSource messageSource;

    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        return true;
    }

    @Override
    public ResponseWrapper beforeBodyWrite(ResponseWrapper wrapper, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        wrapper.setMessage(messageSource.getMessage(wrapper.getMessage(), null, Locale.getDefault()));
        return wrapper;
    }

}
