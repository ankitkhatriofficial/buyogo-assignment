package com.buyogo.assignment.exceptions;

import com.buyogo.assignment.dto.exception.ApiErrorResponse;
import com.buyogo.assignment.enums.ExceptionCode;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.http.HttpStatus;

/**
 * @author Ankit Khatri
 */

@Data
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public class InputValidationException extends RuntimeException{

    private HttpStatus httpStatus = HttpStatus.BAD_REQUEST;
    private ApiErrorResponse apiErrorResponse;

    public InputValidationException(final ExceptionCode exceptionCode) {
        this.apiErrorResponse = new ApiErrorResponse(exceptionCode.getCode(), exceptionCode.getMessage());
    }

    public InputValidationException(final ExceptionCode exceptionCode, final String details) {
        this.apiErrorResponse = new ApiErrorResponse(exceptionCode.getCode(), exceptionCode.getMessage(), details);
    }
}
