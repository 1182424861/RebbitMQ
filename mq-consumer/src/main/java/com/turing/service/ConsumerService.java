package com.turing.service;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Service;

/**
 * @Package:com.turing.service
 * @ClassName:ConsumerService
 * @Author:白衬衫
 * @Date:2022/4/13 21:53
 * @Description:
 */
@Service
public class ConsumerService {

    //接收消息
    @RabbitListener(queues = "usa.news")    //监听指定队列
    public void getMsg1(String msg){
        System.out.println("usa.news:"+msg);
    }

    //接收消息
    @RabbitListener(queues = "usa.weather")    //监听指定队列
    public void getMsg2(String msg){
        System.out.println("usa.weather:"+msg);
    }

    //接收消息
    @RabbitListener(queues = "europe.news")    //监听指定队列
    public void getMsg3(String msg){
        System.out.println("europe.news:"+msg);
    }

    //接收消息
    @RabbitListener(queues = "europe.weather")    //监听指定队列
    public void getMsg4(String msg){
        System.out.println("europe.weather:"+msg);
    }

}
