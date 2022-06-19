package com.turing.service;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Package:com.turing.service
 * @ClassName:ProducerService
 * @Author:白衬衫
 * @Date:2022/4/13 21:39
 * @Description:
 */
@Service
public class ProducerService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    //点对点模式，发送消息
    public void send1(String msg){
        rabbitTemplate.convertAndSend("usa.news",msg);
    }

    //广播模式，发送消息
    public void send2(String msg){
        rabbitTemplate.convertAndSend("b2c.fanout","",msg);
    }

    //匹配模式，发送消息
    public void send3(String msg){
        rabbitTemplate.convertAndSend("b2c.topic","usa.news",msg);
    }

}
