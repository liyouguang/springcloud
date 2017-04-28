/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.conf;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
//@Configuration
public class RabbitManager {
	
	@Value("${spring.rabbit.queue}")
	private String QUEUE_NAME;
	
	@Value("${spring.rabbit.direct.exchange}")
	private String DIRECT_EXCHANGE;
	
	@Value("${spring.rabbit.routing.key}")
	private String ROUTING_KEY;
	
	@Bean
	public Queue queue(){
		Queue queue = new Queue(QUEUE_NAME);
		return queue;
	}
	
    @Bean  
    public DirectExchange defaultExchange() {  
        return new DirectExchange(DIRECT_EXCHANGE);  
    }
    
    @Bean  
    public Binding binding() {  
        return BindingBuilder.bind(queue()).to(defaultExchange()).with(ROUTING_KEY);  
    }  
}
