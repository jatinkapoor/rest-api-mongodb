package com.demo.demo.rest;

import com.demo.demo.domain.request.AccountRequest;
import com.demo.demo.domain.response.AccountResponse;
import com.demo.demo.domain.response.NotFound;
import com.demo.demo.model.Account;
import com.demo.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
public class AccountController {

    @Autowired
    AccountService accountService;

    @RequestMapping(value = "/account", method = RequestMethod.GET)
    public ResponseEntity getAccounts(@RequestParam  String id) {
        Account account = accountService.getAccount(id);
        if (account != null) {
            return ResponseEntity.ok().body(account);
        }
        NotFound notFound = new NotFound();
        notFound.setMessage("account not found for id " +id );
        return ResponseEntity.ok().body(notFound);
    }

    @RequestMapping(value = "/account", method = RequestMethod.POST)
    public ResponseEntity<AccountResponse> createAccount(@RequestBody Account account) {

        Account createdAccount = accountService.createAccount(account);
        AccountResponse accountResponse = new AccountResponse();
        accountResponse.setId(createdAccount.getId());
        return ResponseEntity.ok().body(accountResponse);
    }
}
