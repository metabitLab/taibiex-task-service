package com.taibiex.taskservice.common.exception;


public class Web3jException extends RuntimeException {

    public Web3jException(String message, Throwable cause) {
        super(message, cause);
    }

    public Web3jException(String message) {
        super(message);
    }
}
