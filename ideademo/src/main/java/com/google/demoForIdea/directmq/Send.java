package com.google.demoForIdea.directmq;

import com.google.demoForIdea.common.ConnectionUtil;
import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;

public class Send {

	private final static String EXCHANGE_NAME = "test_exchange_direct";

	public static void main(String[] argv) throws Exception {
		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		Channel channel = connection.createChannel();

		// 声明exchange s1是交换机类型
		channel.exchangeDeclare(EXCHANGE_NAME, "direct");

		// 消息内容
		String message = "删除商品";
		//s1是消息key
		channel.basicPublish(EXCHANGE_NAME, "delete", null, message.getBytes());
		System.out.println(" [x] Sent '" + message + "'");

		channel.close();
		connection.close();
	}
}
