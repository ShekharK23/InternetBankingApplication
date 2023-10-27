package com.app.bank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.app.bank.entity.Branch;

@Repository
public interface IBranchRepository extends JpaRepository<Branch, Integer>{

}
