/**
 * lyg-finance-service
 * @author liyouguang.
 */
package com.lyg.cloud.restful;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.lyg.cloud.domain.FinanceInfoService;
import com.lyg.cloud.model.FinanceInfo;

@RestController
@RequestMapping("/financeInfo")
public class FinanceInfoController {

	@Autowired
	FinanceInfoService financeInfoService;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public List<FinanceInfo> readUserInfo(){
		List<FinanceInfo> ls=financeInfoService.searchAll();		
		return ls;
	}
}
