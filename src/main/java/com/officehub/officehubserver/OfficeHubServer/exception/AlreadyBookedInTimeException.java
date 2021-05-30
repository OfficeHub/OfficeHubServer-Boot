package com.officehub.officehubserver.OfficeHubServer.exception;

public class AlreadyBookedInTimeException extends RuntimeException{
    public AlreadyBookedInTimeException() {
        super();
    }

    public AlreadyBookedInTimeException(String message) {
        super(message);
    }
}
