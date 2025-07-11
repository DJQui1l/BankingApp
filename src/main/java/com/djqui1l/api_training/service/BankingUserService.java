package com.djqui1l.api_training.service;

import com.djqui1l.api_training.model.BankingUser;
import com.djqui1l.api_training.repository.BankingUserRepository;
import org.springframework.stereotype.Service;


import java.util.UUID;
@Service
public class BankingUserService {

//    public BankingUser bankingUser;

    private final BankingUserRepository bankingUserRepository;

    public BankingUserService(BankingUserRepository bankingUserRepository) {
        this.bankingUserRepository = bankingUserRepository;
    }


    public BankingUser createBankingUser(BankingUser user) {
        user.setId(UUID.randomUUID().toString());

        String firstName = user.getFirstName().toLowerCase();
        String lastName = user.getLastName().toLowerCase();
        String email = firstName + "." + lastName + "@banking.com";
        user.setEmail(email);
        return bankingUserRepository.save(user);


    }

    public BankingUser getBankingUser(String userId) {
        return bankingUserRepository.findById(userId).orElse(null);
    }

    public BankingUser updateBankingUser(String userId, BankingUser user) {
        return bankingUserRepository.findById(userId)
                .map(existingUser -> {
                    existingUser.setFirstName(user.getFirstName());
                    existingUser.setLastName(user.getLastName());
                    existingUser.setEmail(user.getEmail());
                    existingUser.setBalance(user.getBalance());
                    return bankingUserRepository.save(existingUser);
                })
                .orElse(null);

    }


    public boolean deleteBankingUser(String userId) {
        if (bankingUserRepository.existsById(userId)) {
            bankingUserRepository.deleteById(userId);
            return true;
        }
        return false;
    }

}

