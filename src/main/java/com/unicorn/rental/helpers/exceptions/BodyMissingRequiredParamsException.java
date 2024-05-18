package com.unicorn.rental.helpers.exceptions;

public class BodyMissingRequiredParamsException extends RuntimeException {


    public BodyMissingRequiredParamsException() {
        super("Request body is missing required params.");
    }
}
