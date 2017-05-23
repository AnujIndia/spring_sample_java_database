package com.pularsight.repository;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;

import com.pularsight.model.Customer;

@Repository("customerRepository")
public class HibernateCustomerRepositoryImpl implements CustomerRepository {

	/* (non-Javadoc)
	 * @see com.pularsight.repository.CustomerRepository#findAll()
	 */
	@Value("${dbUserName}")
	private String dbUserName;
	
	public List<Customer> findAll() {

		List<Customer> customers = new ArrayList<Customer>();
		Customer customer1 = new Customer();
		customer1.setFirstName("Nishi");
		customer1.setLastName("Anuj");

		customers.add(customer1);
		
		System.out.println("Printing DB user name from the properties file" + dbUserName);
		return customers;

	}

}
