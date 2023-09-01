package com.example.demo.exception;

import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.util.Date;

/**
 * Controller advice for handling all the exceptions
 */
@RestControllerAdvice
public class ControllerExceptionHandler {

    /**
     * Exception handler method for handling DataBaseUpsertException
     *
     * @param e e
     * @param webRequest webRequest
     * @return message
     */
    @ExceptionHandler(DataBaseUpsertException.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage databaseUpsertException(DataBaseUpsertException e, WebRequest webRequest) {

        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), e.getMessage(),
                webRequest.getDescription(false));
    }

    /**
     * Exception handler method for handling access denied Exception
     *
     * @param e e
     * @param webRequest webRequest
     * @return message
     */
    @ExceptionHandler(AccessDeniedException.class)
    @ResponseStatus(value = HttpStatus.FORBIDDEN)
    public ErrorMessage accessDeniedException(AccessDeniedException e, WebRequest webRequest) {
        return new ErrorMessage(HttpStatus.FORBIDDEN.value(), new Date(), e.getMessage(),
                webRequest.getDescription(false));
    }

    /**
     * Exception handler method for handling Exception
     *
     * @param e e
     * @param webRequest webRequest
     * @return message ExpiredJwtException
     */
    @ExceptionHandler(Exception.class)
    @ResponseStatus(value = HttpStatus.INTERNAL_SERVER_ERROR)
    public ErrorMessage commonException(Exception e, WebRequest webRequest) {
        return new ErrorMessage(HttpStatus.INTERNAL_SERVER_ERROR.value(), new Date(), e.getMessage(),
                webRequest.getDescription(false));
    }
}
