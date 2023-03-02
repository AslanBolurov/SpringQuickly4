package com.example.purchasedb.TRANSACTIONS.controllers;

import com.example.purchasedb.TRANSACTIONS.dto.TransferRequest;
import com.example.purchasedb.TRANSACTIONS.model.Account;
import com.example.purchasedb.TRANSACTIONS.services.TransferService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest transferRequest
    ) {
        transferService.transferMoney(
                transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(),
                transferRequest.getAmount()
        );
    }

    @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
        return transferService.getAllAccount();
    }
}
