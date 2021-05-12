package com.officehub.officehubserver.OfficeHubServer.dto;

import org.apache.ibatis.type.Alias;

@Alias("Login")
public class LoginDto {
	private int employeeId;
	private String userId;
	private String password;
	
	public LoginDto() {
		
	}
	
	public LoginDto(int employeeId, String userId, String password) {
		this.employeeId = employeeId;
		this.userId = userId;
		this.password = password;
	}
	
	
	public int getEmployeeId() {
		return employeeId;
	}
	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	//추후 경과를 보고 필요시 추가할 내용
//	@Override
//	public String toString() {
//		return "LoginDto{" +
//				", employeeId=" + employeeId +
//				", userId=" + userId +
//				", password=" + password +
//				"}";
//	}
	
	
}
