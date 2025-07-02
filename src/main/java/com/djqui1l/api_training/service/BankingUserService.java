package com.djqui1l.api_training.service;

import com.djqui1l.api_training.model.BankingUser;
import org.springframework.stereotype.Service;

import java.util.UUID;
@Service
public class BankingUserService {

    public BankingUser bankingUser;

    public BankingUser createBankingUser(BankingUser user){
        user.setId(UUID.randomUUID().toString());
        this.bankingUser = user;
        return this.bankingUser;


    }

    public BankingUser getBankingUser(String userId){
        if (userId.equals(this.bankingUser.getId())){
            return this.bankingUser;
        } else {
            return null;
        }
    }

    public BankingUser updateBankingUser(BankingUser user){
        if (user.getId().equals(this.bankingUser.getId())){
            this.bankingUser = user;
            return this.bankingUser;
        } else {
            return null;
        }
    }

    public Boolean deleteBankingUser(String userId){
        if (userId.equals(this.bankingUser.getId())){
            this.bankingUser = null;
            return true;
        } else {
            return false;
        }
    }




}
