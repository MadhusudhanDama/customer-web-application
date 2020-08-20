package com.madhu.io.webapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.madhu.io.webapp.model.Customer;
import com.madhu.io.webapp.repository.WebAppRepository;

@Service
public class CustomerService {
	
	@Autowired
	WebAppRepository repo;
	
	 public List<Customer> listAll(String name) {
	        if (name != null) {
	            return repo.search(name);
	        }
	        return repo.findAll();
	    }


}
