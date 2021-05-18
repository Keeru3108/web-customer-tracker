package com.luv2code.springdemo.controller;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.luv2code.springdemo.dao.Customerdao;
import com.luv2code.springdemo.entity.Customer;
import com.luv2code.springdemo.service.Customerservice;

@Controller
@RequestMapping("/customer")
public class Customercontroller 
{
   //need to inject the DAO into controller class by using dependency injection
	
	@Autowired
	private Customerservice customerservice;
	
   @GetMapping("/list")
	public String listCustomers(Model themodel)
   {
	   
	   
	   //get the customers from dao
	   List<Customer> customers=customerservice.getcustomers();
	   
	   //add the customer to model
	   themodel.addAttribute("customers", customers);
	   
	   
	   
	   return "list-customers";
   }
   
   @GetMapping("/showFormForAdd")
	public String showcustomerform(Model themodel)
  {
	   Customer thecustomer=new Customer();
	   
	   themodel.addAttribute("customer", thecustomer);
	    
	   return "customer-form";
  }
   
    @PostMapping("/saveCustomer")
  	public String savecustomer(@ModelAttribute("customer") Customer thecustomer)
    {
  	    customerservice.savecustomer(thecustomer);
  	    
  	   return "redirect:/customer/list";
    }
    
    @GetMapping("/showupdateform")
    public String showupdateform(@RequestParam("id") int theid,Model themodel)
    {
    	//get the customer from the database
    	Customer thecustomer= customerservice.getcustomers(theid);
    	
    	//set the model attribute to prepopulate the form
    	themodel.addAttribute("customer", thecustomer);
    	//send over to our form
    	
    	
    	return "customer-form";
    }
    
    @GetMapping("/showdeleteform")
    public String delete(@RequestParam("id") int theid)
    {
    	
    	customerservice.deletecustomer(theid);
    	
    	return "redirect:/customer/list";
    }
    
    @GetMapping("/search")
    public String search(@RequestParam("thesearchname") String name,Model themodel)
    {
    	
    	//get the customers from dao
 	   List<Customer> customers=customerservice.search(name);
 	   
 	   //add the customer to model
 	   themodel.addAttribute("customers", customers);
 	   
 	   
 	   
 	   return "list-customers";
    	
    	
    }
    
    
   
}
