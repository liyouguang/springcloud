/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud;

import org.springframework.amqp.rabbit.annotation.EnableRabbit;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.elasticsearch.repository.config.EnableElasticsearchRepositories;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
@EnableDiscoveryClient
@SpringBootApplication
@EnableCaching
@EnableRabbit
@EnableElasticsearchRepositories(basePackages = "com.lyg.cloud.repository")
public class UserApplication extends CachingConfigurerSupport /*implements CommandLineRunner*/ {

		public static void main(String[] args) {
	        SpringApplication.run(UserApplication.class, args);
	    }
		
		/*
		 * @deprecated redis 管理{@Cacheable} bean
		 *	@author youguang.li
		 */
	    @Bean  
	    public CacheManager cacheManager(  
	            @SuppressWarnings("rawtypes") RedisTemplate redisTemplate) {  
	        return new RedisCacheManager(redisTemplate);  
	    }
	    @Bean  
	    public RedisTemplate<String, String> redisTemplate(  
	            RedisConnectionFactory factory) {  
	        StringRedisTemplate template = new StringRedisTemplate(factory);  
	        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);  
	        ObjectMapper om = new ObjectMapper();  
	        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);  
	        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);  
	        jackson2JsonRedisSerializer.setObjectMapper(om);  
	        template.setValueSerializer(jackson2JsonRedisSerializer);  
	        template.afterPropertiesSet();  
	        return template;  
	    }
	    
	    @Bean
		public ConnectionFactory myConnectionFactory() {
			CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
			connectionFactory.setAddresses("10.1.135.65:5672");
			connectionFactory.setUsername("guest");
			connectionFactory.setPassword("guest");
			connectionFactory.setVirtualHost("/");
			connectionFactory.setPublisherConfirms(true); // 必须要设置
			return connectionFactory;
		}

/*	    
		@Autowired
		private ClienteRepository repository;
		@Override
		public void run(String... arg0) throws Exception {
			this.repository.save(new Customer("Alice", "Smith"));
			this.repository.save(new Customer("Bob", "Smith"));
		}*/
	}
