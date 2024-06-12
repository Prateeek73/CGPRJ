package com.apps.bedms.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.apps.bedms.constants.BedStatus;
import com.apps.bedms.dtos.AddBedRequest;
import com.apps.bedms.dtos.BedDetails;
import com.apps.bedms.dtos.HospitalDetails;
import com.apps.bedms.dtos.UpdateBedRequest;
import com.apps.bedms.entities.Bed;
import com.apps.bedms.exceptions.BedNotFoundException;
import com.apps.bedms.exceptions.InvalidBedStatus;
import com.apps.bedms.repository.IBedRepository;
import com.apps.bedms.utilities.BedUtil;

@Service
public class BedService implements IBedService {

	@Autowired
	private IBedRepository repository;

	@Autowired
	private BedUtil bedUtil;

	public Bed findBedById(Long bedId) {
		return repository.findById(bedId)
				.orElseThrow(() -> new BedNotFoundException("Bed was not found for id: " + bedId));
	}

	@Override
	public BedDetails findBedDetailsById(Long bedId) {
		Bed bed = findBedById(bedId);
		HospitalDetails hospitalDetails = bedUtil.getHospitalDetails(bed.getHospitalId());
		return BedUtil.addBedDetails(bed, hospitalDetails);
	}

	@Override
	public BedDetails addBed(AddBedRequest addBedRequest) {
		Bed bed = new Bed();
		bed.setStatus(BedStatus.AVAILABLE);
		bed.setCategory(BedUtil.getBedCategory(addBedRequest.getBedCategory()));
		bed.setChargesPerDay(addBedRequest.getChargesPerDay());
		bed.setHospitalId(addBedRequest.getHospitalId());
		HospitalDetails hospitalDetails = bedUtil.getHospitalDetails(bed.getHospitalId());
		return BedUtil.addBedDetails(repository.save(bed), hospitalDetails);
	}

	@Override
	public BedDetails updateBed(UpdateBedRequest updateBedReqest) {
		Bed bed = findBedById(updateBedReqest.getBedId());
		bed.setStatus(BedStatus.AVAILABLE);
		bed.setCategory(BedUtil.getBedCategory(updateBedReqest.getBedCategory()));
		bed.setChargesPerDay(updateBedReqest.getChargesPerDay());
		bed.setHospitalId(updateBedReqest.getHospitalId());
		HospitalDetails hospitalDetails = bedUtil.getHospitalDetails(bed.getHospitalId());
		return BedUtil.addBedDetails(repository.save(bed), hospitalDetails);
	}

	@Override
	public BedDetails bookBed(Long bedId) {
		Bed bed = findBedById(bedId);
		if (bed.getStatus() == BedStatus.AVAILABLE) {
			bed.setStatus(BedStatus.BOOKED);
			HospitalDetails hospitalDetails = bedUtil.getHospitalDetails(bed.getHospitalId());
			return BedUtil.addBedDetails(repository.save(bed), hospitalDetails);
		}
		throw new InvalidBedStatus(String.format("Bed is %s for bedId: %d", bed.getStatus(), bedId));
	}

	@Override
	public BedDetails cancelBookBed(Long bedId) {
		Bed bed = findBedById(bedId);
		if (bed.getStatus() == BedStatus.BOOKED) {
			bed.setStatus(BedStatus.AVAILABLE);
			HospitalDetails hospitalDetails = bedUtil.getHospitalDetails(bed.getHospitalId());
			return BedUtil.addBedDetails(repository.save(bed), hospitalDetails);
		}
		throw new InvalidBedStatus(String.format("Bed is %s for bedId: %d", bed.getStatus(), bedId));
	}

	@Override
	public BedDetails occupyBed(Long bedId) {
		Bed bed = findBedById(bedId);
		if (bed.getStatus() == BedStatus.BOOKED) {
			bed.setStatus(BedStatus.OCCUPIED);
			HospitalDetails hospitalDetails = bedUtil.getHospitalDetails(bed.getHospitalId());
			return BedUtil.addBedDetails(repository.save(bed), hospitalDetails);
		}
		throw new InvalidBedStatus(String.format("Bed is %s for bedId: %d", bed.getStatus(), bedId));
	}

	
	public BedDetails unoccupyBed(Long bedId) {
		Bed bed = findBedById(bedId);
		if (bed.getStatus() == BedStatus.OCCUPIED) {
			bed.setStatus(BedStatus.AVAILABLE);
			HospitalDetails hospitalDetails = bedUtil.getHospitalDetails(bed.getHospitalId());
			return BedUtil.addBedDetails(repository.save(bed), hospitalDetails);
		}
		throw new InvalidBedStatus(String.format("Bed is %s for bedId: %d", bed.getStatus(), bedId));
	}

	@Override
	public List<BedDetails> findNearByAvailableBeds(Long pincode) {
		List<Long> hospitalIds = bedUtil.getNearbyHospitalsIds(pincode);
		return repository.getBedsByHospitalId(hospitalIds).stream()
				.filter(bed -> bed.getStatus() == BedStatus.AVAILABLE)
				.map(bed -> BedUtil.addBedDetails(bed, bedUtil.getHospitalDetails(bed.getHospitalId())))
				.collect(Collectors.toUnmodifiableList());
	}
}
