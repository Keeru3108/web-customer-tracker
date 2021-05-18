package com.luv2code.springdemo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.dao.Customerdao;
import com.luv2code.springdemo.entity.Customer;

@Service
public class Customerserviceimpl implements Customerservice {

	@Autowired
	private Customerdao customerdao;
	
	@Override
	@Transactional
	public List<Customer> getcustomers() 
	{
			return customerdao.getcustomers();
	}

	@Override
	@Transactional
	public void savecustomer(Customer thecustomer) {
		// TODO Auto-generated method stub
		customerdao.savecustomer(thecustomer);
	}

	@Override
	@Transactional
	public Customer getcustomers(int theid) {
		// TODO Auto-generated method stub
		return customerdao.getcustomers(theid);
	}

	@Override
	@Transactional
	public void deletecustomer(int theid) {
		// TODO Auto-generated method stub
		customerdao.delete(theid);
	}

	@Override
	@Transactional
	public List<Customer> search(String name) {
		// TODO Auto-generated method stub
		return customerdao.search(name);
	}
	
	

}
