package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bean.Flat;

public interface FlatRepository extends JpaRepository<Flat, String> {
	@Query("SELECT f FROM Flat f " +
	           "WHERE f.flatPrice = (SELECT MIN(flatPrice) FROM Flat) " +
	           "AND f.numberOfRooms = (SELECT MAX(numberOfRooms) FROM Flat)")
	List<Flat> findFlatWithMinPriceAndMaxRooms();
	
}