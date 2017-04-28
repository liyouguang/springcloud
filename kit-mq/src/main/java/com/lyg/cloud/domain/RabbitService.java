/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.domain;

import java.io.IOException;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rabbitmq.client.Channel;

@Service
public class RabbitService {
    /*
	 * 有两种方式使用rabbitMQ：
	 * 1 是注入RabbitTemplate，在代码逻辑中使用set等方法操作redis客户端
	 * 2 是使用@Cacheable等注解，但在Application中必须添加bean CacheManager,RedisTemplate
	 * 
	 */
    @Autowired
    private ConnectionFactory myConnectionFactory;
    @Autowired
    private AmqpTemplate amqpTemplate;
	public String createQueueKit(String queueName,String exchange,String routingKey){
//		 ConnectionFactory factory = new ConnectionFactory();
       Connection connection = myConnectionFactory.createConnection();
       Channel channel = connection.createChannel(false);
       try {
			channel.queueDeclare(queueName, false, false, false, null);
			channel.exchangeDeclare(exchange, "direct");
			channel.queueBind(queueName, exchange, routingKey);
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			try {
				channel.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
			connection.close();
		}
	    return "ok";
	}
}
