package com.pws.LogUser.exception;

public class PhoneNumberNotFoundException extends RuntimeException {
    String message = "Phone Number Not Found";

    public PhoneNumberNotFoundException(){
        super();
    }

    public PhoneNumberNotFoundException(String message) {
        super();
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }
}
