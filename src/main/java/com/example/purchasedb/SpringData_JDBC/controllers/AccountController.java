package com.example.purchasedb.SpringData_JDBC.controllers;


import com.example.purchasedb.SpringData_JDBC.dto.TransferRequest;
import com.example.purchasedb.SpringData_JDBC.model.Account;
import com.example.purchasedb.SpringData_JDBC.services.TransferService;
import org.springframework.web.bind.annotation.*;

@RestController
public class AccountController {

    private final TransferService transferService;

    public AccountController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping("/transfer")
    public void transferMoney(
            @RequestBody TransferRequest transferRequest
    ){
        transferService.transferMoney(
                transferRequest.getSenderAccountId(),
                transferRequest.getReceiverAccountId(),
                transferRequest.getAmount()
        );
    }

    @GetMapping("/account")
    public Iterable<Account> getAllAccounts(
            @RequestParam(required = false) String name
    ){
        if (name ==null){
            return transferService.getAllAccounts();
        }else
            return transferService.findAccountsByName(name);
    }
}
