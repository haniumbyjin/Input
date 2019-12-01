package com.conference.chatting.model.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum ReqNation {

    Asia(82, "Asia");


    private int code;
    private String message;
}
