package com.conference.chatting.model.wrapper;

import com.conference.chatting.model.enums.ResStatusCode;
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

    public ResponseWrapper (ResStatusCode resStatusCode) {
        this.code = resStatusCode.getCode();
        this.message = resStatusCode.getMessage();
    }

    public ResponseWrapper (ResStatusCode resStatusCode, T t) {
        this.code = resStatusCode.getCode();
        this.message = resStatusCode.getMessage();
        this.data = t;
    }

}
