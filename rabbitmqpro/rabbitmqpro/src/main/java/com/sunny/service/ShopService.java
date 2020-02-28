/*
 * Created by IntelliJ IDEA.
 * User: VULCAN
 * Date: 2020/2/11
 * Time: 18:04
 */
package com.sunny.service;

import com.rabbitmq.client.Channel;
import com.sunny.bo.Userinfos;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.AmqpHeaders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.Headers;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Component;

import java.util.Map;

@Component
public class ShopService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @RabbitListener(
            //绑定队列
            bindings = @QueueBinding(
                    //绑定队列名称,允许序列号
                    value = @Queue(value = "shop-queue",durable = "true"),
                    //绑定虚拟机 类型为topic 我的虚拟机,将消息并列发布.发一个消费一个
                    exchange = @Exchange(value = "shop-exchange",durable = "true",type = "topic"),
                    //* 号代表一个单词,#号代表零个或多个单词
                    key = "shop.*"
            )
    )
    @RabbitHandler
    public void execConsumer(
            @Payload Userinfos user,
            @Headers Map<String,Object> header,
            Channel channel
    )throws Exception{
        //消费者操作
        System.out.println("接受shop消息:"+user.getUsername()+user.getUserid());
        //获取签收消息

        Long ordid = (Long) header.get(AmqpHeaders.DELIVERY_TAG);

        channel.basicAck(ordid,false);
       // rabbitTemplate.convertAndSend();

    }
}