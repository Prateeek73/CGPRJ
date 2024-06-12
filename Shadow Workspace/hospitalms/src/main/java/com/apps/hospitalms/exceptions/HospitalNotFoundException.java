package com.apps.hospitalms.exceptions;

public class HospitalNotFoundException extends RuntimeException {

    public HospitalNotFoundException(String msg) {
        super(msg);
    }

}
