package com.footstep.domain.base.exception;

public class InvalidFormatException extends IllegalArgumentException {

    public InvalidFormatException(final String message) {
        super(message);
    }
}