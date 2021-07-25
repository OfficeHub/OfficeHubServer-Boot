package com.officehub.officehubserver.SpringSecurity;

public interface AuthToken<T> {
	boolean validate();
	T getData();
}
