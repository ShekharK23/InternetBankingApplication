package com.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.entity.Beneficiary;

@Repository
public interface IBeneficiaryRepository extends JpaRepository<Beneficiary, Long>{

}
