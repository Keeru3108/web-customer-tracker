package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface Customerdao 
{
   public List<Customer> getcustomers();

public void savecustomer(Customer thecustomer);

public Customer getcustomers(int theid);

public void delete(int theid);

public List<Customer> search(String name);
}
