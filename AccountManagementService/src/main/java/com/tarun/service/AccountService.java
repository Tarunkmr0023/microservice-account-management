package com.tarun.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import com.tarun.entity.Account;
import com.tarun.exception.DetailsNotMatchException;
import com.tarun.exception.ResourceNotFoundException;
import com.tarun.repository.AccountRepository;

@Service
public class AccountService {
	@Autowired
	private AccountRepository accountRepo;

	public Account saveAccount(Account account) {
		return accountRepo.save(account);
	}

	public List<Account> saveAccounts(List<Account> accounts) {
		return accountRepo.saveAll(accounts);
	}

	public Account updateAccount(Account account) {
		Account existingAccount = accountRepo.findById(account.getAccountNo()).orElseThrow(
				() -> new ResourceNotFoundException("Account with given account no. not found on server."));
		existingAccount.setCustomerId(account.getCustomerId());
		return accountRepo.save(existingAccount);
	}

	public List<Account> getAccounts() {
		return accountRepo.findAll();
	}

	public Account getAccountById(int id) {
		return accountRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Account with given account no. not found on server."));
	}

	public String deleteAccount(int id) {
		Account account = accountRepo.findById(id).orElseThrow(
				() -> new ResourceNotFoundException("Account with given account no. not found on server."));
		accountRepo.deleteById(id);
		return ("Account with account no. : " + id + " deleted.");
	}

	public Account addMoney(Account account) {
		Account existingAccount = accountRepo.findById(account.getAccountNo()).orElseThrow(
				() -> new ResourceNotFoundException("Account with given account no. not found on server."));
		if (existingAccount.getCustomerId() != account.getCustomerId()) {
			throw new DetailsNotMatchException("Account no. and customer id mismatch !!");
		}
		int existingBalance = existingAccount.getBalance();
		int updatedBalance = existingBalance + account.getBalance();
		existingAccount.setBalance(updatedBalance);
		return accountRepo.save(existingAccount);
	}

	public Account withdrawMoney(Account account) {
		Account existingAccount = accountRepo.findById(account.getAccountNo()).orElseThrow(
				() -> new ResourceNotFoundException("Account with given account no. not found on server."));
		if (existingAccount.getCustomerId() != account.getCustomerId()) {
			throw new DetailsNotMatchException("Account no. and customer id mismatch !!");
		}
		int existingBalance = existingAccount.getBalance();
		if (existingBalance < account.getBalance()) {
			return null;
		}
		int updatedBalance = existingBalance - account.getBalance();
		existingAccount.setBalance(updatedBalance);
		return accountRepo.save(existingAccount);
	}
}
