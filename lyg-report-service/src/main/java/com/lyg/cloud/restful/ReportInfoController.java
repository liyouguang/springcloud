/**
 * lyg-report-service
 * @author liyouguang.
 */
package com.lyg.cloud.restful;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.domain.ReportInfoService;
import com.lyg.cloud.model.ReportInfo;

@RestController
@RequestMapping("/reportInfo")
public class ReportInfoController {

	@Autowired
	ReportInfoService reportInfoService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<ReportInfo> readUserInfo(){
		List<ReportInfo> ls=reportInfoService.searchAll();		
		return ls;
	}
}
