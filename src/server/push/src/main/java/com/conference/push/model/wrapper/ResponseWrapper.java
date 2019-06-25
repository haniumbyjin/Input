package com.conference.push.model.wrapper;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseWrapper<T> {

    private int code;
    private String message;
    private T data;

    public ResponseWrapper (T t) {
        this.code = 0;
        this.message = "success";
        this.data = t;
    }

}
