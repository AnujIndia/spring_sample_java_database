package com.pularsight.service;

import java.util.List;

import com.pularsight.model.Customer;

public interface CustomerService {

	public abstract List<Customer> findAll();

}