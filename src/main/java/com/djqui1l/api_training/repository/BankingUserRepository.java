package com.djqui1l.api_training.repository;

import com.djqui1l.api_training.model.BankingUser;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface BankingUserRepository extends JpaRepository<BankingUser, String>{


}
