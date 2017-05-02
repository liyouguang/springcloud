package com.lyg.cloud.restful;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.domain.ResourcesService;
import com.lyg.cloud.model.Resources;

@RestController
@RequestMapping("/resources")
public class ResourcesController {

	@Autowired
	ResourcesService resourcesService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<Resources> readUserInfo(){
		List<Resources> ls=resourcesService.searchAll();		
		return ls;
	}
}
