package com.example.iocspring;

import org.springframework.stereotype.Component;

import java.util.Base64;

@Component("base74Encoder") // 이름 지정 가능
public class Base64Encoder implements IEncoder {

    public String encode(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

}
