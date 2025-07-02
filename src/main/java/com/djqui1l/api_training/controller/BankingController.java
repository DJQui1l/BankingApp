package com.djqui1l.api_training.controller;

import com.djqui1l.api_training.model.BankingUser;
import com.djqui1l.api_training.service.BankingUserService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/banking")
public class BankingController {

    public BankingUser bankingUser;

    @Autowired
    BankingUserService bankingUserService;

    @GetMapping("/{userId}")
    public ResponseEntity<BankingUser> getBankingUser(@PathVariable String userId){
        BankingUser bankingUser = bankingUserService.getBankingUser(userId);
        return new ResponseEntity<>(bankingUser, HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<BankingUser> createUser(@RequestBody BankingUser user){
        BankingUser createdUser = bankingUserService.createBankingUser(user);
        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);

    }


    @PutMapping("/update")
    public ResponseEntity<BankingUser> updateBankingUser(@RequestBody BankingUser user){

        if (bankingUserService.updateBankingUser(user) != null) {
            BankingUser updatedUser = bankingUserService.updateBankingUser(user);
            return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
        } else{
            return ResponseEntity.notFound().build();

        }



    }

    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteBankingUser(@PathVariable String userId){
        if (bankingUserService.deleteBankingUser(userId)) {
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("User " + userId + " not found.");
        }
    }
}
