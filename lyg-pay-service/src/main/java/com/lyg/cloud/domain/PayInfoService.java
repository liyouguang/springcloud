package com.lyg.cloud.domain;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyg.cloud.dao.PayInfoDao;
import com.lyg.cloud.model.PayInfo;



@Service
@Transactional
public class PayInfoService {

	
	@Autowired
	private PayInfoDao payInfoMapper;
	
	public List<PayInfo> searchAll(){
		List<PayInfo> list = payInfoMapper.findAll();
		return list;
	}
}
