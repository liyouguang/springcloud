package com.lyg.cloud.restful;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.domain.PayInfoService;
import com.lyg.cloud.model.PayInfo;

@RestController
@RequestMapping("/payInfo")
public class PayInfoController {

	@Autowired
	PayInfoService payInfoService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<PayInfo> readUserInfo(){
		List<PayInfo> ls=payInfoService.searchAll();		
		return ls;
	}
}
