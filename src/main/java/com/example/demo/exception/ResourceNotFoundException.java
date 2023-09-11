package com.example.demo.exception;

import java.io.Serial;

/**
 * Custom exception for resource not found
 */
public class ResourceNotFoundException extends RuntimeException {

    @Serial
    private static final long serialVersionUID = 1708236615905032839L;

    public ResourceNotFoundException(String message) {
        super(message);
    }
}
