package com.conference.chatting.advice;

import com.conference.chatting.exception.ExampleException;
import com.conference.chatting.model.enums.ResStatusCode;
import com.conference.chatting.model.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    @ExceptionHandler(ExampleException.class)
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<ResponseWrapper> exampleExceptionHandler() {
      log.error("Example Exception");
      return new ResponseEntity<>(new ResponseWrapper(ResStatusCode.EXAMPLE_ERROR), HttpStatus.OK);
    }

}
