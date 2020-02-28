/*
 * Created by IntelliJ IDEA.
 * User: VULCAN
 * Date: 2020/2/11
 * Time: 21:36
 */
package com.rmq.service;

import com.sunny.bo.Userinfos;

import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
public class SendMsgService {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    public  void  sendUserMsg(Userinfos user){
        CorrelationData cd = new CorrelationData();
        //准备一个地址.保证不相同
        cd.setId("$"+UUID.randomUUID().toString());
        //注册一个虚拟机.接受user.*的信息.
        rabbitTemplate.convertAndSend("user-exchange","user.abc",user,cd);
    }
    public  void  sendShopMsg(Userinfos user){
        CorrelationData cd = new CorrelationData();
        //准备一个地址.保证不相同
        cd.setId("$"+UUID.randomUUID().toString());
        //注册一个虚拟机.接受top.*的信息.
        rabbitTemplate.convertAndSend("shop-exchange","shop.abc",user,cd);
    }

}
