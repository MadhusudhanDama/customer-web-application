package com.madhu.io.webapp.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.madhu.io.webapp.model.Customer;

@Repository
public interface WebAppRepository extends JpaRepository<Customer, Long> {

	@Query("SELECT c FROM Customer c WHERE c.name LIKE %?1%")
	public List<Customer> search(String name);

}
