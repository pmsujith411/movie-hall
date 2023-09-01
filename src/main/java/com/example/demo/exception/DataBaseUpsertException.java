package com.example.demo.exception;

/**
 * Custom exception
 */
public class DataBaseUpsertException extends RuntimeException {

    private static final long serialVersionUID = -5656216210816870423L;

    public DataBaseUpsertException(String message) {
        super(message);
    }
}
