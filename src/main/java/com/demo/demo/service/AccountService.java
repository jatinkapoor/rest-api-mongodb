package com.demo.demo.service;

import com.demo.demo.model.Account;
import com.demo.demo.repository.AccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountService {

    @Autowired
    private AccountRepository accountRepository;

    public Account getAccount(String id) {
        return accountRepository.findById(id).orElse(null);
    }

    public List<Account> getAll() {
        return accountRepository.findAll();
    }

    public Account createAccount(Account account) {
        return accountRepository.save(account);
    }

    public Boolean delete(String id) {
        accountRepository.deleteById(id);
        Boolean exists = accountRepository.existsById(id);
        return exists;
    }

    public Account updateAccount(Account account){
        return accountRepository.save(account);
    }

}


