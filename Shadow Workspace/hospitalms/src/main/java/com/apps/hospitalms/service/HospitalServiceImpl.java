package com.apps.hospitalms.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.hospitalms.dto.AddHospitalRequest;
import com.apps.hospitalms.dto.HospitalDetails;
import com.apps.hospitalms.dto.UpdateHospitalRequest;
import com.apps.hospitalms.entity.Address;
import com.apps.hospitalms.entity.Hospital;
import com.apps.hospitalms.exceptions.HospitalNotFoundException;
import com.apps.hospitalms.repository.IHospitalRepository;
import com.apps.hospitalms.util.HospitalUtil;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class HospitalServiceImpl implements IHospitalService {

	@Autowired
	private IHospitalRepository repository;

	@Override
	public HospitalDetails add(AddHospitalRequest request) {
		Hospital hospital = new Hospital();
		hospital.setHospitalName(request.getHospitalName());
		hospital.setHospitalType(HospitalUtil.toEnum(request.getHospitalType()));
		hospital.setAddress(new Address(request.getCity(), request.getState(), request.getPincode()));
		return HospitalUtil.toHospitalDetails(repository.save(hospital));
	}

	@Override
	public HospitalDetails update(UpdateHospitalRequest request) {
		Hospital hospital = findHospitalById(request.getId());
		hospital.setHospitalName(request.getHospitalName());
		hospital.setHospitalType(HospitalUtil.toEnum(request.getHospitalType()));
		hospital.setAddress(new Address(request.getCity(), request.getState(), request.getPincode()));
		return HospitalUtil.toHospitalDetails(repository.save(hospital));
	}

	public Hospital findHospitalById(Long id) {
		Optional<Hospital> optional = repository.findById(id);
		if (!optional.isPresent())
			throw new HospitalNotFoundException("Hospital not found for id: " + id);
		return optional.get();
	}

	@Override
	public HospitalDetails findHospitalDetailsById(Long id) {
		return HospitalUtil.toHospitalDetails(findHospitalById(id));
	}

	@Override
	public List<HospitalDetails> findNearByHospitals(Long pincode) {
		Long pincodeStart = (pincode / 100) * 100;
		Long pincodeEnd = (pincode / 100) * 100 + 99;
		return repository.getHospitalByPincode(pincodeStart, pincodeEnd)
				.stream()
				.map(HospitalUtil::toHospitalDetails)
				.collect(Collectors.toList());
	}
}
