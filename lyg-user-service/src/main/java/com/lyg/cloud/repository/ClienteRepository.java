/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.repository;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import com.lyg.cloud.model.Customer;  
  
public interface ClienteRepository extends ElasticsearchRepository<Customer, String>  
{  
}  