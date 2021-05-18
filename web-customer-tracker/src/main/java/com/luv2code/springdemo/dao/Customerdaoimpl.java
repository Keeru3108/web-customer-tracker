package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.luv2code.springdemo.entity.Customer;

@Repository
public class Customerdaoimpl implements Customerdao{

	//need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
	
	@Override
	public List<Customer> getcustomers() {
		
		//get the current hibernate session
		
		Session currentsession = sessionFactory.getCurrentSession();
		
		//create the query
	Query<Customer> thequery=(Query<Customer>) currentsession.createQuery("from Customer order By lastname");
		
		//execute the query
	List<Customer> customers=thequery.getResultList();
		
		//return the result
	return customers;
		
	}

	@Override
	public void savecustomer(Customer thecustomer) {
		
		Session currentsession=sessionFactory.getCurrentSession();
		
		currentsession.saveOrUpdate(thecustomer);
	}

	@Override
	public Customer getcustomers(int theid) {
		// TODO Auto-generated method stub
		Session currentsession=sessionFactory.getCurrentSession();
		
		Customer thecustomer=currentsession.get(Customer.class,theid);
		
		return thecustomer;
	}

	@Override
	public void delete(int theid) {
		
		Session currentsession=sessionFactory.getCurrentSession();
		
		Query query=currentsession.createQuery("delete from Customer where id=:customerid");
		
		query.setParameter("customerid",theid);
		
		query.executeUpdate();
		
	
	}

	@Override
	public List<Customer> search(String name) {
		// TODO Auto-generated method stub
		Session currentsession=sessionFactory.getCurrentSession();
		
		Query query=null;
		
		if(name!=null || name.trim().length()>0)
		{
		query=currentsession.createQuery("from Customer where lower(firstname) like :theName or lower(lastname) like :theName", Customer.class);
		query.setParameter("theName", "%" + name.toLowerCase() + "%");
		}
		else {
            // theSearchName is empty ... so just get all customers
            query =currentsession.createQuery("from Customer",Customer.class);            
        }
        
        // execute query and get result list
        List<Customer> customers = query.getResultList();
                
        // return the results        
         return customers;
	}

}
