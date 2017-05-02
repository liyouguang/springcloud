package com.lyg.cloud.restful;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.domain.SocialInfoService;
import com.lyg.cloud.model.SocialInfo;

@RestController
@RequestMapping("/socialInfo")
public class SocialInfoController {

	@Autowired
	SocialInfoService socialInfoService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<SocialInfo> readUserInfo(){
		List<SocialInfo> ls=socialInfoService.searchAll();		
		return ls;
	}
}
