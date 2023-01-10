package com.java.assigment.repository;


import com.java.assigment.dto.AccountDTO;
import com.java.assigment.dto.request.AccountCreateRequest;
import com.java.assigment.entity.Account;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountRepository extends JpaRepository<Account, Integer> {
    Optional<Account> findByEmailAndPassword(String email, String password);

    Optional<Account> findByEmail(String email);

}
