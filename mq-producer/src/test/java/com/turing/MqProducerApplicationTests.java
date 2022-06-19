package com.turing;

import com.turing.service.ProducerService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class MqProducerApplicationTests {

    @Autowired
    private ProducerService producerService;

    //测试点对点模式发送消息
    @Test
    void test1() {
        producerService.send1("Hello MQ!(direct)");
    }

    //测试广播模式发送消息
    @Test
    void test2() {
        producerService.send2("Hello MQ!(fanout)");
    }

    //测试匹配模式发送消息
    @Test
    void test3() {
        producerService.send2("Hello MQ!(topic)");
    }

}
