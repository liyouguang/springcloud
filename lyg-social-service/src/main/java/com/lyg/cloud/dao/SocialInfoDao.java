package com.lyg.cloud.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.lyg.cloud.model.SocialInfo;

@Repository
public interface SocialInfoDao {

	List<SocialInfo> findAll();
}
