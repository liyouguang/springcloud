package com.lyg.cloud.restful;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.domain.OrderInfoService;
import com.lyg.cloud.model.OrderInfo;

@RestController
@RequestMapping("/orderInfo")
public class OrderInfoController {

	@Autowired
	OrderInfoService orderInfoService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<OrderInfo> readUserInfo(){
		List<OrderInfo> ls=orderInfoService.searchAll();		
		return ls;
	}
}
