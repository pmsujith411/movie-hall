package com.example.demo.exception;

/**
 * Custom exception
 */
public class DataBaseException extends RuntimeException {

    private static final long serialVersionUID = -5656216210816870423L;

    public DataBaseException(String message) {
        super(message);
    }
}
