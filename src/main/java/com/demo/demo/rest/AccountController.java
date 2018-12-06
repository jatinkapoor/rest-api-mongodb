package com.demo.demo.rest;

import com.demo.demo.domain.response.AccountResponse;
import com.demo.demo.domain.response.NotFound;
import com.demo.demo.model.Account;
import com.demo.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ResponseEntity getAccount(@RequestParam  String id) {
        Account account = accountService.getAccount(id);
        if (account != null) {
            return ResponseEntity.ok().body(account);
        }
        NotFound notFound = new NotFound();
        notFound.setMessage("Account not found for id " +id );
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(notFound);
    }

    @RequestMapping(value = "/accounts", method = RequestMethod.GET)
    public ResponseEntity getAccounts() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(accountService.getAll());
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<AccountResponse> createAccount(@RequestBody Account account) {

        Account createdAccount = accountService.createAccount(account);
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(createdAccount.getId());
        return ResponseEntity.status(HttpStatus.CREATED).body(accountResponse);
    }

    @RequestMapping(value = "/account", method = RequestMethod.DELETE)
    public ResponseEntity deleteAccount(@RequestParam String id) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.delete(id));
    }

    @RequestMapping(value = "/account", method = RequestMethod.PUT)
    public ResponseEntity<Boolean> updateAccount(@RequestBody Account account) {
        return ResponseEntity.status(HttpStatus.OK).body(accountService.updateAccount(account));
    }
}
