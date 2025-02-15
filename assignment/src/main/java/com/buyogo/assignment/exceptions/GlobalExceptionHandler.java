package com.buyogo.assignment.exceptions;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author Ankit Khatri
 */

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(InputValidationException.class)
    public ResponseEntity<?> handleValidationExceptions(final InputValidationException ex) {
        return ResponseEntity.status(ex.getHttpStatus()).body(ex.getApiErrorResponse());
    }
}
