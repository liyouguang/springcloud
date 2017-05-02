/**
 * lyg-finance-service
 * @author liyouguang.
 */
package com.lyg.cloud.domain;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyg.cloud.dao.FinanceInfoDao;
import com.lyg.cloud.model.FinanceInfo;

@Service
@Transactional
public class FinanceInfoService {

	@Autowired
	private FinanceInfoDao financeInfoMapper;
	
	public List<FinanceInfo> searchAll(){
		List<FinanceInfo> list = financeInfoMapper.findAll();
		return list;
	}
}
