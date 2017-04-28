/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.restful;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.domain.UserService;
import com.lyg.cloud.model.User;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<User> readUserInfo(){
		List<User> ls=userService.searchAll();		
		return ls;
	}
	
	@RequestMapping(value="/single/{userId}",method=RequestMethod.GET)
	public User readUserById(@PathVariable(value="userId")String id){
		return userService.searchUserById(id);		
	}
	
	@RequestMapping(value="/queue/{queue}/{exchange}/{routingKey}",method=RequestMethod.GET)
	public String  createQueue(@PathVariable(value="queue")String queueName,
			@PathVariable(value="exchange")String exchange,
			@PathVariable(value="routingKey")String routingKey) {
		return userService.createQueueKit(queueName, exchange, routingKey);
		
	}
}
