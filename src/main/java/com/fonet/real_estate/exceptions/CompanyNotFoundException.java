package com.fonet.real_estate.exceptions;

import org.springframework.http.HttpStatus;

public class CompanyNotFoundException extends RealEstateException{
    public CompanyNotFoundException(String message) {
        super(message, HttpStatus.NOT_FOUND);
    }
}
