/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.domain.RabbitService;

@RestController
@RequestMapping("/rabbit")
public class RabbitController {
	@Autowired
	private RabbitService rabbitService;
	@RequestMapping(value="/queue/{queue}/{exchange}/{routingKey}",method=RequestMethod.GET)
	public String  createQueue(@PathVariable(value="queue")String queueName,
			@PathVariable(value="exchange")String exchange,
			@PathVariable(value="routingKey")String routingKey) {
		return rabbitService.createQueueKit(queueName, exchange, routingKey);
		
	}
}
