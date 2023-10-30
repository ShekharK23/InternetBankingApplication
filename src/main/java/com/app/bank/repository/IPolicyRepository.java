package com.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.entity.Policy;

@Repository
public interface IPolicyRepository extends JpaRepository<Policy, Long>{

}
