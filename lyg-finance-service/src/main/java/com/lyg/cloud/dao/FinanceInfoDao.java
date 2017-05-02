/**
 * lyg-finance-service
 * @author liyouguang.
 */
package com.lyg.cloud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.cloud.model.FinanceInfo;

@Repository
public interface FinanceInfoDao {

	List<FinanceInfo> findAll();
}
