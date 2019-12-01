package com.conference.push.advice;

import com.conference.push.model.enums.ResStatusCode;
import com.conference.push.model.wrapper.ResponseWrapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerAdvice {

    public ResponseEntity<ResponseWrapper> exampleExceptionHandler() {
        log.error("Example Exception");
        return new ResponseEntity<>(new ResponseWrapper(ResStatusCode.EXAMPLE_ERROR), HttpStatus.OK);
    }
}
