package com.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.entity.DebitCard;

@Repository
public interface IDebitCardRepository extends JpaRepository<DebitCard, Long>{

}
