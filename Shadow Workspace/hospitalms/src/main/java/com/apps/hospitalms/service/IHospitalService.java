package com.apps.hospitalms.service;

import org.springframework.validation.annotation.Validated;

import com.apps.hospitalms.dto.AddHospitalRequest;
import com.apps.hospitalms.dto.HospitalDetails;
import com.apps.hospitalms.dto.UpdateHospitalRequest;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import java.util.List;

@Validated
public interface IHospitalService {

    HospitalDetails add(@Valid AddHospitalRequest request);

    HospitalDetails update(@Valid UpdateHospitalRequest request);

    HospitalDetails findHospitalDetailsById(@Min(1) Long id);

    List<HospitalDetails> findNearByHospitals(@Min(1) @Max(999999) Long pincode);

}
