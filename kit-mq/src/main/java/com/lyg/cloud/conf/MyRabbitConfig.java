package com.lyg.cloud.conf;

import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRabbitConfig {
	
	@Value("${spring.rabbitmq.host}")
	private String HOST;
	@Value("${spring.rabbitmq.port}")
	private String PORT;
	@Value("${spring.rabbitmq.username}")
	private String USERNAME;
	@Value("${spring.rabbitmq.password}")
	private String PASSWORD;

	@Bean
	public ConnectionFactory myConnectionFactory() {
		CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
		connectionFactory.setAddresses(HOST+":"+PORT);
		connectionFactory.setUsername(USERNAME);
		connectionFactory.setPassword(PASSWORD);
		connectionFactory.setVirtualHost("/");
		connectionFactory.setPublisherConfirms(true); // 必须要设置
		return connectionFactory;
	}
}
