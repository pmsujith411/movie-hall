package com.example.demo.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * Custom error message structure
 */
@Data
@AllArgsConstructor
public class ErrorMessage {
    private int statusCode;
    private Date timestamp;
    private String message;
    private String description;
}
