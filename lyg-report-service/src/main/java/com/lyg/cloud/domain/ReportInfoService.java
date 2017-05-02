/**
 * lyg-report-service
 * @author liyouguang.
 */
package com.lyg.cloud.domain;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyg.cloud.dao.ReportInfoDao;
import com.lyg.cloud.model.ReportInfo;

@Service
@Transactional
public class ReportInfoService {

	@Autowired
	private ReportInfoDao reportInfoMapper;
	
	public List<ReportInfo> searchAll(){
		List<ReportInfo> list = reportInfoMapper.findAll();
		return list;
	}
}
