package com.productbackend.advisor.expections;

public class NotFoundException extends RuntimeException {

    public NotFoundException(Long id) {
        super(String.format("The product under %d hasn't been found.", id));
    }
}
