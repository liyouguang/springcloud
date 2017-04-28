/**
 * lyg-notice-service
 * @author liyouguang.
 */
package com.lyg.cloud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.cloud.model.NoticeInfo;

@Repository
public interface NoticeInfoDao {

	List<NoticeInfo> findAll();
}
