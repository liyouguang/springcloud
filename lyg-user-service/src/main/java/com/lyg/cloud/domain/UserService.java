/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.domain;


import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeoutException;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitAdmin;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyg.cloud.dao.UserDao;
import com.lyg.cloud.model.User;
import com.rabbitmq.client.Channel;



@Service
@Transactional
public class UserService {

	/*
	 * 有两种方式使用redis：
	 * 1 是注入StringRedisTemplate，在代码逻辑中使用set等方法操作redis客户端
	 * 2 是使用@Cacheable等注解，但在Application中必须添加bean CacheManager,RedisTemplate
	 * 
	 */
    @Autowired
    private StringRedisTemplate stringRedisTemplate;
    
    
    
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
    
	@Autowired
	private UserDao userMapper;
	
	
	public List<User> searchAll(){
		List<User> list = userMapper.findAll();
		stringRedisTemplate.opsForValue().set("redis-test", "111");
		return list;
	}
	
	//@Cacheable(value = "user", key="'userId_'+#id")
	public User searchUserById(String id){
		User user = userMapper.findUserById(id);
		amqpTemplate.convertAndSend("world", "test-rabbit");
		return user;
	}
	
	
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
