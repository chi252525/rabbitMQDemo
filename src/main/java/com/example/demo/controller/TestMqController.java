package com.example.demo.controller;

import com.example.demo.mq.MqDto;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestMqController {
    @Autowired
    RabbitTemplate rabbitTemplate;

    @RequestMapping("/mq/send")
    public String sendToQueue() {
        rabbitTemplate.convertAndSend("liongogo.test.queue", new MqDto("liongogo"));
        return "發佈消息成功";
    }
}
