package com.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.entity.Account;

@Repository
public interface IAccountRepository extends JpaRepository<Account, Long>{

}
