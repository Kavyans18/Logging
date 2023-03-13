package com.pws.LogUser.exception;

public class EmailNotFoundException extends RuntimeException{

    String message = "No data found under this Email id";

    public EmailNotFoundException(){
        super();
    }

    public EmailNotFoundException(String message){
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
