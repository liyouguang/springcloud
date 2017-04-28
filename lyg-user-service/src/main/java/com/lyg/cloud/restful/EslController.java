package com.lyg.cloud.restful;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.domain.EslService;

@RestController  
@RequestMapping(value = "/esl/")  
public class EslController {
    
	@Autowired  
    private EslService esl;  
    
    @RequestMapping(value = "test", method = RequestMethod.POST)  
    public Object test(@RequestBody  String id)  {  
        return esl.findCliente(id);  
    }  
}
