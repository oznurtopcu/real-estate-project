package com.fonet.real_estate.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class RealEstateException extends RuntimeException{

    private HttpStatus httpStatus;

    public RealEstateException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
