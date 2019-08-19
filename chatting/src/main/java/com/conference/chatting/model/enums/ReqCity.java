package com.conference.chatting.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReqCity {

    Seoul(02, "Seoul");

    private int code;
    private String message;
}
