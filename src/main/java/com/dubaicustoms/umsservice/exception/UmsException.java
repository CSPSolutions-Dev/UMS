package com.dubaicustoms.umsservice.exception;

import org.springframework.http.HttpStatus;

import java.io.Serial;

public class UmsException extends Exception {
    @Serial
    private static final long serialVersionUID = 1L;
    private final String message;
    private final HttpStatus httpStatus;


    public UmsException(String message) {
        super(message);
        this.message = message;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public UmsException(String msg, HttpStatus httpStatus) {
        super(msg);
        this.httpStatus = httpStatus;
        this.message = msg;
    }

    public UmsException(String msg, Throwable cause) {
        super(msg, cause);
        this.message = msg;
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;

    }

    public UmsException(Throwable cause) {
        super(cause);
        this.message = "";
        this.httpStatus = HttpStatus.INTERNAL_SERVER_ERROR;
    }

    public HttpStatus getHttpStatus() {
        return httpStatus;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
