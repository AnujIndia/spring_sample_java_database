package com.pularsight.repository;

import java.util.List;

import com.pularsight.model.Customer;

public interface CustomerRepository {

	public abstract List<Customer> findAll();

}