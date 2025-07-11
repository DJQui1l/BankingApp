package com.djqui1l.api_training.repository;

import com.djqui1l.api_training.model.BankingUser;
import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface BankingUserRepository extends MongoRepository<BankingUser, String>{


}
