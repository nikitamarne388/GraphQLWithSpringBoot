package com.learning.ecommerceApplication.exceptions;

public class ResourceNotFoundException {

    public static RuntimeException throwResourceNotFoundException() {
        throw new RuntimeException("Resource Not Found");
    }
}
