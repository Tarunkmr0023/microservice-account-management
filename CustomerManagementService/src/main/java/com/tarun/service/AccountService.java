package com.tarun.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.tarun.entity.Account;

@Component
@FeignClient(name="ACCOUNT-MICROSERVICE")
public interface AccountService {
	@PostMapping("account/addAccount")
	public ResponseEntity<Account> addAccount(@RequestBody Account account);
	
	@DeleteMapping("account/{accountNo}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accountNo") int accountNo);
}
