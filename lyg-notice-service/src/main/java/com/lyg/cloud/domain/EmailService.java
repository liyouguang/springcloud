/**
 * lyg-notice-service
 * @author liyouguang.
 */
package com.lyg.cloud.domain;


import java.util.List;

import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.lyg.cloud.dao.NoticeInfoDao;
import com.lyg.cloud.model.NoticeInfo;

@Service
@Transactional
@RabbitListener(queues= "${spring.rabbit.queue}")
public class EmailService {

	@Autowired
	private NoticeInfoDao noticeInfoMapper;
	
	@RabbitHandler
    public void process(String message) {
        System.out.println("Receiver : " + message+". Email!!");
        this.addMessage2DB();
    }
	
	//消息入库
	public void addMessage2DB(){
		System.out.println("入库");
	}
	
	
	
	
	
	
	
	
	
	public List<NoticeInfo> searchAll(){
		List<NoticeInfo> list = noticeInfoMapper.findAll();
		return list;
	}
}
