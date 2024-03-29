package com.officehub.officehubserver.OfficeHubServer.dto;

import org.apache.ibatis.type.Alias;

@Alias("Login")
public class LoginDto {
	
	private String user_Id;
	private String password;
	
	public LoginDto() {
		
	}
	
	public LoginDto(String user_Id, String password) {
		this.user_Id = user_Id;
		this.password = password;
	}
	

	public String getUserId() {
		return user_Id;
	}
	public void setUserId(String user_Id) {
		this.user_Id = user_Id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
}
