package com.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.entity.Account;
import com.app.bank.entity.Investment;

@Repository
public interface IInvestmentRepository extends JpaRepository<Investment, Long> {
<<<<<<< HEAD
=======

>>>>>>> 2e8d56ca2aeb36ebed7025b125d2297485f05a6b
	public void deleteByAccount(Account account);
}
