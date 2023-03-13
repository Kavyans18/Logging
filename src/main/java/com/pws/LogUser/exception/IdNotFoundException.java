package com.pws.LogUser.exception;

public class IdNotFoundException extends RuntimeException {
    private String message = "Id not found";

    public IdNotFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
