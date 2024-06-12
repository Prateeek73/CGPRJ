package com.apps.bedms.utilities;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import com.apps.bedms.constants.BedStatus;
import com.apps.bedms.constants.BedCategory;
import com.apps.bedms.dtos.BedDetails;
import com.apps.bedms.dtos.HospitalDetails;
import com.apps.bedms.entities.Bed;
import com.apps.bedms.exceptions.InvalidBedCategory;
import com.apps.bedms.exceptions.InvalidBedStatus;

@Component
public class BedUtil {

	@Value("${hospital.baseUrl}")
	private String baseHospitalUrl;

	@Autowired
	private RestTemplate restTemplate;
	
	public static BedDetails addBedDetails(Bed bed, HospitalDetails hospitalDetails) {
		BedDetails bedDetails = new BedDetails();
		bedDetails.setBedId(bed.getId());
		bedDetails.setBedStatus(bed.getStatus().toString());
		bedDetails.setBedCategory(bed.getCategory().toString());
		bedDetails.setChargesPerDay(bed.getChargesPerDay());
		bedDetails.setHospitalDetails(hospitalDetails);
		return bedDetails;
	}

	public static BedStatus getBedStatus(String bedStatus) {
		for (BedStatus status : BedStatus.values())
			if (bedStatus.equals(status.toString()))
				return status;
		throw new InvalidBedStatus("Invalid Bed Status request: " + bedStatus);
	}

	public static BedCategory getBedCategory(String bedCategory) {
		for (BedCategory category : BedCategory.values())
			if (bedCategory.equals(category.toString()))
				return category;
		throw new InvalidBedCategory("Invalid Bed Category request: " + bedCategory);
	}

	public HospitalDetails getHospitalDetails(Long id) {
		String url = baseHospitalUrl + "/findById/" + id;
		return restTemplate.getForObject(url, HospitalDetails.class);
	}

	public List<Long> getNearbyHospitalsIds(Long pincode) {
		String url = baseHospitalUrl + "/findNearByHospital/" + pincode;
		ResponseEntity<HospitalDetails[]> response = restTemplate.getForEntity(url, HospitalDetails[].class);
		HospitalDetails[] arrayList = response.getBody();
		List<HospitalDetails> hospitalList = new ArrayList<>();
		Collections.addAll(hospitalList, arrayList);
		return hospitalList.stream()
				.map(HospitalDetails::getHospitalId)
				.collect(Collectors.toUnmodifiableList());
	}
}
