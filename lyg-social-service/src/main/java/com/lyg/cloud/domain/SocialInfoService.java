package com.lyg.cloud.domain;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyg.cloud.dao.SocialInfoDao;
import com.lyg.cloud.model.SocialInfo;

@Service
@Transactional
public class SocialInfoService {

	@Autowired
	private SocialInfoDao socialInfoMapper;
	
	public List<SocialInfo> searchAll(){
		List<SocialInfo> list = socialInfoMapper.findAll();
		return list;
	}
}
