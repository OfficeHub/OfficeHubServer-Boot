package com.officehub.officehubserver.OfficeHubServer.dto;

import javax.annotation.Nonnull;

import org.apache.ibatis.type.Alias;

@Alias("userinfo") // mybatis 별칭
public class UserInfoDto {
	@Nonnull private int employee_id;
    private String name;
    private String department;
    private String phone_no;    
    private String profile_url;

	public UserInfoDto(int employee_id, String name, String department, String phone_no, String profile_url) {
    	this.employee_id = employee_id;
        this.name = name;
        this.department = department;
        this.phone_no = phone_no;        
        this.profile_url = profile_url;
    }
	
	public int getEmployee_id() {
		return employee_id;
	}

	public void setEmployee_id(int employee_id) {
		this.employee_id = employee_id;
	}
	

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

	public String getPhone_no() {
		return phone_no;
	}

	public void setPhone_no(String phone_no) {
		this.phone_no = phone_no;
	}

	public String getProfile_url() {
		return profile_url;
	}

	public void setProfile_url(String profile_url) {
		this.profile_url = profile_url;
	}
  
}
