package com.turing.config;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Package:com.turing.config
 * @ClassName:RabbitmqConfig
 * @Author:白衬衫
 * @Date:2022/4/13 21:34
 * @Description:RabbitMQ配置项
 */
@Configuration
public class RabbitmqConfig {

    //第一种模式：点对点模式【direct】
    //默认就是点对点模式，所以不需要交换机
    //配置要绑定的消息队列
    @Bean(name = "queue1")
    public Queue queue1(){
        return new Queue("usa.news");
    }
    @Bean(name = "queue2")
    public Queue queue2(){
        return new Queue("usa.weather");
    }
    @Bean(name = "queue3")
    public Queue queue3(){
        return new Queue("europe.news");
    }
    @Bean(name = "queue4")
    public Queue queue4(){
        return new Queue("europe.weather");
    }

//=========================================================

    //第二种模式：广播模式（一对多）【fanout】
    //第一步：配置广播模式的交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("b2c.fanout");
    }

    //第二步：配置要绑定的消息队列    【同上】

    //第三步给交换机绑定所需队列
    @Bean
    public Binding binding1(@Qualifier("queue1")Queue queue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
    @Bean
    public Binding binding2(@Qualifier("queue2")Queue queue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
    @Bean
    public Binding binding3(@Qualifier("queue3")Queue queue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }
    @Bean
    public Binding binding4(@Qualifier("queue4")Queue queue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(queue).to(fanoutExchange);
    }

//=========================================================

    //第三种模式：转发模式（匹配模式）【topic】
    //第一步：创建交换机
    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("b2c.topic");
    }

    //第二步：配置要绑定的消息队列    【同上】

    //第三步：绑定消息队列
    @Bean
    public Binding binding11(@Qualifier("queue1")Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("usa.news");
    }
    @Bean
    public Binding binding22(@Qualifier("queue2")Queue queue, TopicExchange topicExchange){
        return BindingBuilder.bind(queue).to(topicExchange).with("usa.#");
    }


}
