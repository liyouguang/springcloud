package com.lyg.cloud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.cloud.model.PayInfo;

@Repository
public interface PayInfoDao {

	List<PayInfo> findAll();
}
