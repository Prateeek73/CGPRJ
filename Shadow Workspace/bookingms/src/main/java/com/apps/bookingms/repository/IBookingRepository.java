package com.apps.bookingms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.apps.bookingms.entity.Booking;

public interface IBookingRepository extends JpaRepository<Booking,Long> {
    
	@Query("from Booking WHERE patientId=:pid")
    List<Booking> findBookingByPatientId(@Param("pid") Long patientId);
}
