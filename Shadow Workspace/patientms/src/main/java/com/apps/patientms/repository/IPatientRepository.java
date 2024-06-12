package com.apps.patientms.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.apps.patientms.entity.Patient;

public interface IPatientRepository extends JpaRepository<Patient, Long> {

}
