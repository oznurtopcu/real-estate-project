package com.fonet.real_estate.exceptions;

import org.springframework.http.HttpStatus;

public class ListingNotFoundException extends RealEstateException {
    public ListingNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
