package com.lyg.cloud.domain;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyg.cloud.dao.OrderInfoDao;
import com.lyg.cloud.model.OrderInfo;



@Service
@Transactional
public class OrderInfoService {

	
	@Autowired
	private OrderInfoDao orderInfoMapper;
	
	public List<OrderInfo> searchAll(){
		List<OrderInfo> list = orderInfoMapper.findAll();
		return list;
	}
}
