package com.tarun.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tarun.entity.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {

}
