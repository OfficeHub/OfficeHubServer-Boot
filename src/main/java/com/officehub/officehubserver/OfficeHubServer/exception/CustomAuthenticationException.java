package com.officehub.officehubserver.OfficeHubServer.exception;

public class CustomAuthenticationException extends RuntimeException {
	
	public CustomAuthenticationException() {
		super(ErrorCode.AUTHENTICATION_FAILED.getMessage());
	}
	
	public CustomAuthenticationException(Exception ex) {
		super(ex);
	}
}
