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
public class AccountController {
	@Autowired
	private AccountService accountService;
	@Autowired
	private CustomerService customerService;

	@PostMapping("account/addAccount")
	public ResponseEntity<Account> addAccount(@RequestBody Account account) {
		Account account1 = accountService.saveAccount(account);
		return ResponseEntity.status(HttpStatus.CREATED).body(account1);
	}

	@PostMapping("account/addAccounts")
	public ResponseEntity<List<Account>> addAccounts(@RequestBody List<Account> accounts) {
		List<Account> saved_accounts = accountService.saveAccounts(accounts);
		return ResponseEntity.status(HttpStatus.CREATED).body(saved_accounts);
	}

	@PutMapping("account/updateAccount")
	public ResponseEntity<Account> updateAccount(@RequestBody Account account) {
		Account account1 = accountService.updateAccount(account);
		return ResponseEntity.ok(account1);
	}

	@PutMapping("account/addMoney")
	public ResponseEntity<Account> addMoney(@RequestBody Account account) {
		Account account1 = accountService.addMoney(account);
		return ResponseEntity.ok(account1);
	}

	@PutMapping("account/withdrawMoney")
	public ResponseEntity<Account> withdrawMoney(@RequestBody Account account) {
		Account account1 = accountService.withdrawMoney(account);
		if (account1 == null) {
			return ResponseEntity.badRequest().body(null);
		}
		return ResponseEntity.ok(account1);
	}

	@GetMapping("accounts")
	public ResponseEntity<List<Account>> getAllAccounts() {
		List<Account> accounts = accountService.getAccounts();
		return ResponseEntity.ok(accounts);
	}

	@GetMapping("account/{accountNo}")
	public ResponseEntity<AccountDetails> getAccountById(@PathVariable("accountNo") int accountNo) {
		Account account=accountService.getAccountById(accountNo);
		ResponseEntity<Customer> resp=customerService.getCustomerById(account.getCustomerId());
		Customer customer=(Customer) resp.getBody();
		AccountDetails details=new AccountDetails(account.getAccountNo(),account.getCustomerId(),account.getBalance(),customer.getFirstName(),customer.getLastName(),customer.getDob());
		return ResponseEntity.ok(details);
	}

	@DeleteMapping("account/{accountNo}")
	public ResponseEntity<String> deleteAccount(@PathVariable("accountNo") int accountNo) {
		String resp = accountService.deleteAccount(accountNo);
		return ResponseEntity.ok(resp);
	}
}
