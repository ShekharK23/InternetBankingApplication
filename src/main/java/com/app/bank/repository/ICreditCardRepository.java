package com.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.entity.CreditCard;

@Repository
public interface ICreditCardRepository extends JpaRepository<CreditCard, Long>{

}
