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
        Boolean exists = accountRepository.existsById(id);
        if (exists == true) {
            accountRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public Boolean updateAccount(Account account){
        Boolean exists = accountRepository.existsById(account.getId());
        if (exists) {
             Account updatedAccount = accountRepository.save(account);
             if (updatedAccount.getId() == account.getId()) {
                 return true;
             } else {
                 return false;
             }
        } else {
            return false;
        }
    }

}


