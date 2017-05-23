package com.pularsight.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import com.pularsight.model.Customer;
import com.pularsight.repository.CustomerRepository;

@Service("customerService")
@Scope(ConfigurableBeanFactory.SCOPE_SINGLETON)
public class CustomerServiceImpl implements CustomerService {
	
	//private CustomerRepository customerRepository = new HibernateCustomerRepositoryImpl();
	
	///@Autowired
	private CustomerRepository customerRepository;
	
	
	public CustomerServiceImpl(){
		super();
	}
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		System.out.println("We are using the constructor injection");
		this.customerRepository = customerRepository;
	}

	@Autowired
	public void setCustomerRepository(CustomerRepository customerRepository) {
		System.out.println("We are using the setter injection");
		this.customerRepository = customerRepository;
	}


	/* (non-Javadoc)
	 * @see com.pularsight.service.CustomerService#findAll()
	 */
	public List<Customer> findAll(){
		return customerRepository.findAll();
	}

}
