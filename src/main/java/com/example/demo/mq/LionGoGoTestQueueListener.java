package com.example.demo.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues={"liongogo.test.queue"})
public class LionGoGoTestQueueListener {
    @RabbitHandler
    public void receive(MqDto mqDto) {
        System.out.println("從queue中接收到消息:"+mqDto.getBody());
    }
}
