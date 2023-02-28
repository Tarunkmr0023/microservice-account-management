package com.tarun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tarun.entity.Customer;
import com.tarun.exception.ResourceNotFoundException;
import com.tarun.repository.CustomerRepository;

@Service
public class CustomerService {
	@Autowired
	private CustomerRepository customerRepo;
	
	public Customer saveCustomer(Customer customer)
	{
		return customerRepo.save(customer);
	}
	public List<Customer> saveCustomers(List<Customer> customers)
	{
		return customerRepo.saveAll(customers);
	}
	public Customer updateCustomer(Customer customer)
	{
		Customer existingCustomer=customerRepo.findById(customer.getCustomerId()).orElseThrow(()->new ResourceNotFoundException("Customer with given customer id not found on the server !!"));
		existingCustomer.setAccountNo(customer.getAccountNo());
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setDob(customer.getDob());
		return customerRepo.save(existingCustomer);
	}
	public List<Customer> getCustomers()
	{
		return customerRepo.findAll();
	}
	public Customer getCustomerById(int id)
	{
		return customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer with given customer id not found on the server !!"));
	}
	public String deleteCustomer(int id)
	{
		Customer customer=customerRepo.findById(id).orElseThrow(()->new ResourceNotFoundException("Customer with given customer id not found on the server !!"));
		customerRepo.deleteById(id);
		return ("Customer with id : "+id+" deleted.");
	}
}
