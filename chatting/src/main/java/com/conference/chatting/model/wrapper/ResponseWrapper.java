package com.conference.chatting.model.wrapper;

import lombok.*;

@Setter
@Getter
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
