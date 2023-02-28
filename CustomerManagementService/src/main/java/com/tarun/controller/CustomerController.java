package com.tarun.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.tarun.entity.Account;
import com.tarun.entity.AccountDetails;
import com.tarun.entity.Customer;
import com.tarun.service.AccountService;
import com.tarun.service.CustomerService;

@RestController
public class CustomerController {
	@Autowired
	private CustomerService customerService;
	@Autowired
	private AccountService accountService;
	
	@PostMapping("customer/addCustomer")
	public ResponseEntity<AccountDetails> addCustomer(@RequestBody Customer customer) {
		Customer saved_customer=customerService.saveCustomer(customer);
		ResponseEntity<Account> resp=accountService.addAccount(new Account(saved_customer.getAccountNo(),saved_customer.getCustomerId(),0));
		Account account=(Account)resp.getBody();
		AccountDetails details=new AccountDetails(account.getAccountNo(),account.getCustomerId(),account.getBalance(),saved_customer.getFirstName(),saved_customer.getLastName(),saved_customer.getDob());
		return ResponseEntity.status(HttpStatus.CREATED).body(details);
	}

	@PostMapping("customer/addCustomers")
	public ResponseEntity<List<Customer>> addCustomers(@RequestBody List<Customer> customers) {
		List<Customer> saved_customers=customerService.saveCustomers(customers);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved_customers);
	}

	@PutMapping("customer/updateCustomer")
	public ResponseEntity<Customer> updateCustomer(@RequestBody Customer customer) {
		Customer updatedCustomer=customerService.updateCustomer(customer);
		return ResponseEntity.ok(updatedCustomer);
	}

	@GetMapping("customers")
	public ResponseEntity<List<Customer>> getAllCustomers() {
		List<Customer> customers=customerService.getCustomers();
		return ResponseEntity.ok(customers);
	}

	@GetMapping("customer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId) {
		Customer customer=customerService.getCustomerById(customerId);
		return ResponseEntity.ok(customer);
	}

	@DeleteMapping("customer/{customerId}")
	public ResponseEntity<String> deleteCustomer(@PathVariable("customerId") int customerId) {
		Customer customer=customerService.getCustomerById(customerId);
		ResponseEntity<String> resp=accountService.deleteAccount(customer.getAccountNo());
		String account_message=(String)resp.getBody();
		String customer_message=customerService.deleteCustomer(customerId);
		return ResponseEntity.ok(account_message+" and "+customer_message);
	}
}
