package com.lyg.cloud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.cloud.model.Resources;

@Repository
public interface ResourcesDao {

	List<Resources> findAll();
}
