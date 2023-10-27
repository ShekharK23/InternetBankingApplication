package com.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.entity.Investment;

@Repository
public interface IInvestmentRepository extends JpaRepository<Investment, Long> {

}
