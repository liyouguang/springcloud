/**
 * lyg-notice-service
 * @author liyouguang.
 */
package com.lyg.cloud.domain;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyg.cloud.dao.NoticeInfoDao;
import com.lyg.cloud.model.NoticeInfo;

@Service
@Transactional
public class NoticeInfoService {

	@Autowired
	private NoticeInfoDao noticeInfoMapper;
	
	public List<NoticeInfo> searchAll(){
		List<NoticeInfo> list = noticeInfoMapper.findAll();
		return list;
	}
}
