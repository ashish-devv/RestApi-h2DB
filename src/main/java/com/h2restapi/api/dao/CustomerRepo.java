package com.h2restapi.api.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.h2restapi.api.entity.Customer;

public interface CustomerRepo extends JpaRepository<Customer, Integer>{
	public Customer findById(int id);

}
