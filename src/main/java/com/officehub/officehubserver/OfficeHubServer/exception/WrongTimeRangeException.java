package com.officehub.officehubserver.OfficeHubServer.exception;

public class WrongTimeRangeException extends RuntimeException{
    public WrongTimeRangeException() {
        super();
    }

    public WrongTimeRangeException(String message) {
        super(message);
    }
}
