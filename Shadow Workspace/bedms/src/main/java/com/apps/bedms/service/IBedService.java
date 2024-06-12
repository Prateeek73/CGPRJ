package com.apps.bedms.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;

import org.springframework.validation.annotation.Validated;

import com.apps.bedms.dtos.AddBedRequest;
import com.apps.bedms.dtos.BedDetails;
import com.apps.bedms.dtos.UpdateBedRequest;

@Validated
public interface IBedService {
	BedDetails addBed(@Valid AddBedRequest requestData);

	BedDetails updateBed(@Valid UpdateBedRequest updateBedReqest);

	BedDetails findBedDetailsById(@Min(1) Long bedId);

	BedDetails bookBed(@Min(1) Long bedId);

	BedDetails cancelBookBed(@Min(1) Long bedId);

	BedDetails occupyBed(@Min(1) Long bedId);

	BedDetails unoccupyBed(@Min(1) Long bedId);

	List<BedDetails> findNearByAvailableBeds(@Min(1) @Max(999999) Long pincode);

}
