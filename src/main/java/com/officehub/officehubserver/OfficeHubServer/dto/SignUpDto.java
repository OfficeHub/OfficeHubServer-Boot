package com.officehub.officehubserver.OfficeHubServer.dto;

import org.apache.ibatis.type.Alias;

@Alias("SignUp")
public class SignUpDto {
	
	private String email;
	private String name;
	private String department;
	private String phone_no;
	private String hire_date;
	private String job_title;
	private String position;
	private String gender;
	private String birth_date;
	private String profile_url;
	
	public SignUpDto() {
		
	}
	
	
	public SignUpDto(String email, String name, String department, String phone_no, String hire_date, String job_title, String position, String gender, String birth_date, String profile_url) {
		this.email = email;
		this.name = name;
		this.department = department;
		this.phone_no = phone_no;
		this.hire_date = hire_date;
		this.job_title = job_title;
		this.position = position;
		this.gender = gender;
		this.birth_date = birth_date;
		this.profile_url = profile_url;
	}
	
	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
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

	public String getHire_date() {
		return hire_date;
	}

	public void setHire_date(String hire_date) {
		this.hire_date = hire_date;
	}

	public String getJob_title() {
		return job_title;
	}

	public void setJob_title(String job_title) {
		this.job_title = job_title;
	}

	public String getPosition() {
		return position;
	}


	public void setPosition(String position) {
		this.position = position;
	}


	public String getGender() {
		return gender;
	}


	public void setGender(String gender) {
		this.gender = gender;
	}


	public String getBirth_date() {
		return birth_date;
	}


	public void setBirth_date(String birth_date) {
		this.birth_date = birth_date;
	}


	public String getProfile_url() {
		return profile_url;
	}


	public void setProfile_url(String profile_url) {
		this.profile_url = profile_url;
	}

}
