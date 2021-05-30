package com.officehub.officehubserver.OfficeHubServer.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiError<T> {
    private final String exceptionType;
    private final String message;
    private final int status;

    public ApiError(T exceptionType, String message, int status) {
        this.exceptionType = exceptionType.getClass().getSimpleName();
        this.message = message;
        this.status = status;
    }
}
