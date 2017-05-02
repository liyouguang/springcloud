package com.lyg.cloud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.cloud.model.OrderInfo;

@Repository
public interface OrderInfoDao {

	List<OrderInfo> findAll();
}
