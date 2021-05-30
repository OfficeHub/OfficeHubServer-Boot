package com.officehub.officehubserver.OfficeHubServer.exception;

public class BadRequestFormatException extends RuntimeException{
    public BadRequestFormatException() {
        super();
    }

    public BadRequestFormatException(String message) {
        super(message);
    }
}
