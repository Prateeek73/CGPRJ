package com.apps.hospitalms.util;

import com.apps.hospitalms.constants.HospitalType;
import com.apps.hospitalms.dto.HospitalDetails;
import com.apps.hospitalms.entity.Hospital;
import com.apps.hospitalms.exceptions.InvalidHospitalTypeException;

public class HospitalUtil {

    public static HospitalType toEnum(String hospitalType) {
        HospitalType[] hospitalTypes = HospitalType.values();
        for (HospitalType iterator : hospitalTypes) {
            String iteratedHospitalType = iterator.toString();
            if (iteratedHospitalType.equalsIgnoreCase(hospitalType))
                return iterator;
        }
        throw new InvalidHospitalTypeException("Invalid hospital type exception.\nHospitals of type allowed: GOVT, SEMI_PRIVATE, PRIVATE");
    }

    public static HospitalDetails toHospitalDetails(Hospital hospital) {
        HospitalDetails hospitalDetails = new HospitalDetails();
        hospitalDetails.setHospitalId(hospital.getId());
        hospitalDetails.setHospitalName(hospital.getHospitalName());
        hospitalDetails.setHospitalAddress(hospital.getAddress());
        hospitalDetails.setHospitalType(hospital.getHospitalType().toString());
        return hospitalDetails;
    }
}