package com.officehub.officehubserver.OfficeHubServer.dto;

import org.apache.ibatis.type.Alias;

@Alias("AddAccount")
public class AddAccountDto {
	
	private int employee_Id;
	private String user_Id;
	private String password;
	
	public AddAccountDto() {
		
	}
	
	public AddAccountDto(int employee_Id, String userId, String password){
		this.employee_Id = employee_Id;
		this.user_Id = userId;
		this.password = password;		
	}
	
	public int getEmployeeId() {
		return employee_Id;
	}
	public void setEmployeeId(int employee_Id) {
		this.employee_Id = employee_Id;
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
