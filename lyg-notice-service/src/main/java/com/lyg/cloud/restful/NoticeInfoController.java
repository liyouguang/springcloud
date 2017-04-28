/**
 * lyg-notice-service
 * @author liyouguang.
 */
package com.lyg.cloud.restful;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.domain.NoticeInfoService;
import com.lyg.cloud.model.NoticeInfo;

@RestController
@RequestMapping("/noticeInfo")
public class NoticeInfoController {

	@Autowired
	NoticeInfoService noticeInfoService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<NoticeInfo> readUserInfo(){
		List<NoticeInfo> ls=noticeInfoService.searchAll();		
		return ls;
	}
	
	
	public void sendEmail(){
		
	}

	public void sendShortMessage(){
		
	}
	
}
