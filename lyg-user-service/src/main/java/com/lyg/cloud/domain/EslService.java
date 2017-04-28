/**
 * lyg-user-service
 * @author liyouguang
 */
package com.lyg.cloud.domain;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.lyg.cloud.model.Customer;
import com.lyg.cloud.repository.ClienteRepository;

@Service 
public class EslService {
	
	@Autowired  
    private ClienteRepository clienteDao;
	
	public Customer findCliente(String id){
		Customer cliente = clienteDao.findOne(id);
		return cliente;
	}
}
