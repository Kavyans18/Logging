package com.pws.LogUser.exception;

public class NameNotFoundException extends RuntimeException{

    String message = "No Data found under this name";

    public NameNotFoundException(){
        super();
    }
    public NameNotFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
