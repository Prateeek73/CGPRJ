package com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.Buyer;

public interface BuyerRepository extends JpaRepository<Buyer, String> {

}