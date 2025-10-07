package com.fonet.real_estate.exceptions;

import org.springframework.http.HttpStatus;

public class RealEstateNotFoundException extends RealEstateException {
    public RealEstateNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
