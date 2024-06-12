package com.apps.hospitalms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apps.hospitalms.entity.Hospital;

import java.util.List;

public interface IHospitalRepository extends JpaRepository<Hospital, Long> {

	@Query("SELECT h FROM Hospital h INNER JOIN h.address a WHERE a.pincode>=:startPincode AND a.pincode<=:endPincode")
	List<Hospital> getHospitalByPincode(@Param("startPincode") Long startPincode, @Param("endPincode") Long endPincode);
}
