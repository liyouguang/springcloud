package com.lyg.cloud.domain;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyg.cloud.dao.ResourcesDao;
import com.lyg.cloud.model.Resources;



@Service
@Transactional
public class ResourcesService {

	
	@Autowired
	private ResourcesDao resourcesMapper;
	
	public List<Resources> searchAll(){
		List<Resources> list = resourcesMapper.findAll();
		return list;
	}
}
