package com.buyogo.assignment.enums;

import lombok.Getter;

/**
 * @author Ankit Khatri
 */
@Getter
public enum ExceptionCode {

    INVALID_INPUT_DATA(400, "Invalid input data"),
    TRAINING_CENTER_NOT_FOUND(1001, "No training center found for the provided id");

    private Integer code;
    private String message;

    ExceptionCode(final Integer code, final String message){
        this.code = code;
        this.message = message;
    }

}
