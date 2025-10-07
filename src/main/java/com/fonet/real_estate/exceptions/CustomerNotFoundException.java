package com.fonet.real_estate.exceptions;

import org.springframework.http.HttpStatus;

public class CustomerNotFoundException extends RealEstateException {
    public CustomerNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);

    }
}
