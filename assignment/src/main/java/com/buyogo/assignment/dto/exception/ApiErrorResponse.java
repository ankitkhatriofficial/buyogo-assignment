package com.buyogo.assignment.dto.exception;

import lombok.Data;

import java.io.Serializable;
import java.time.Instant;

/**
 * @author Ankit Khatri
 */

@Data
public class ApiErrorResponse implements Serializable {

    private static final long serialVersionUID = 87399333L;

    private Integer code;
    private String message;
    private String details;
    private String timestamp;

    public ApiErrorResponse(final Integer code, final String message){
        this.code = code;
        this.message = message;
        this.timestamp = Instant.now().toString();
    }

    public ApiErrorResponse(final Integer code, final String message, final String details){
        this(code, message);
        this.details = details;
        this.timestamp = Instant.now().toString();
    }
}
