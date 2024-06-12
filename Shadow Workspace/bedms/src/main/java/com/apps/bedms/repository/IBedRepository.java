package com.apps.bedms.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import com.apps.bedms.entities.Bed;

public interface IBedRepository extends JpaRepository<Bed, Long> {

	@Query("FROM Bed WHERE status = 'AVAILABLE' AND hospital_id in (:hospitalIds)")
    List<Bed> getBedsByHospitalId(@Param("hospitalIds") List<Long> hospitalIds);

}
