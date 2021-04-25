package com.officehub.officehubserver.OfficeHubServer.dto;

import org.apache.ibatis.type.Alias;

@Alias("Userinfo") // mybatis 별칭
public class UserInfo {
	private int id;
    private String name;
    private String department;
    private String PhoneNum;    
    private String Photo;

    public UserInfo(int id, String name, String department, String Phonenum, String Photo) {
    	this.id = id;
        this.name = name;
        this.department = department;
        this.PhoneNum = Phonenum;        
        this.Photo = Photo;
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

	public String getPhoneNum() {
		return PhoneNum;
	}

	public void setPhoneNum(String phoneNum) {
		PhoneNum = phoneNum;
	}

	public String getPhoto() {
		return Photo;
	}

	public void setPhoto(String photo) {
		Photo = photo;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
  
}
