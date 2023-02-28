package com.tarun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarun.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

}
