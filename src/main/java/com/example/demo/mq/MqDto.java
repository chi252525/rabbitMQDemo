package com.example.demo.mq;

import java.io.Serializable;

public class MqDto implements Serializable {
    public MqDto() {

    }

    public MqDto(Object body) {
        this.setBody(body);
    }

    private Object body;

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
