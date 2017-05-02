/**
 * lyg-report-service
 * @author liyouguang.
 */
package com.lyg.cloud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.cloud.model.ReportInfo;

@Repository
public interface ReportInfoDao {

	List<ReportInfo> findAll();
}
