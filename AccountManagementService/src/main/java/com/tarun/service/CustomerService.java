package com.tarun.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.tarun.entity.Customer;
@Component
@FeignClient(name="CUSTOMER-MICROSERVICE")
public interface CustomerService {
	@GetMapping("customer/{customerId}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("customerId") int customerId);
}
