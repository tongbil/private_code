package com.google.demoForIdea.directmq;

import com.google.demoForIdea.common.ConnectionUtil;
import com.rabbitmq.client.*;

import java.io.IOException;

public class Recv2 {

	private final static String QUEUE_NAME = "test_queue_direct_2";

	private final static String EXCHANGE_NAME = "test_exchange_direct";

	public static void main(String[] argv) throws Exception {

		// 获取到连接以及mq通道
		Connection connection = ConnectionUtil.getConnection();
		Channel channel = connection.createChannel();

		// 声明队列
		channel.queueDeclare(QUEUE_NAME, false, false, false, null);

		// 绑定队列到交换机
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "insert");
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "update");
		channel.queueBind(QUEUE_NAME, EXCHANGE_NAME, "delete");

		// 同一时刻服务器只会发一条消息给消费者
		channel.basicQos(1);
		DefaultConsumer consumer = new DefaultConsumer(channel) {
			@Override
			public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body)
					throws IOException {
				//获取并转成String
				String message = new String(body, "UTF-8");
				System.out.println("-->消费者2号，收到消息,msg :"+message);
				//休眠
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}finally {
					channel.basicAck(envelope.getDeliveryTag(),false);//手动确认
				}

			}
		};
		//自动回复队列应答 -- RabbitMQ中的消息确认机制
		channel.basicConsume(QUEUE_NAME, true, consumer);
	}
}
