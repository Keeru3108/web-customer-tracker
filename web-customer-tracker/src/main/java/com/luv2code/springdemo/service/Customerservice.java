package com.luv2code.springdemo.service;

import java.util.List;

import com.luv2code.springdemo.entity.Customer;

public interface Customerservice 
{
   public List<Customer> getcustomers();

public void savecustomer(Customer thecustomer);

public Customer getcustomers(int theid);

public void deletecustomer(int theid);

public List<Customer> search(String name);
}
