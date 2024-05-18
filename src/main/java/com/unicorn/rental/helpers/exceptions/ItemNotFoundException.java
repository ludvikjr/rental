package com.unicorn.rental.helpers.exceptions;

import org.springframework.http.ResponseEntity;

public class ItemNotFoundException extends RuntimeException {

    public ItemNotFoundException() {
        super("Item has not been found.");
    }
}
