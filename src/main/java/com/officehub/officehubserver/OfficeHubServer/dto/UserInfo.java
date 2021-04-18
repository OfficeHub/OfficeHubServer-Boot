package com.officehub.officehubserver.OfficeHubServer.dto;

public class UserInfo {
	private int id;
    private String name;
    private String department;
    private String PhoneNum;
    private String Comment;
    private String Photo;

    public UserInfo(int id, String name, String department, String Phonenum, String Commnet, String Photo) {
    	this.id = id;
        this.name = name;
        this.department = department;
        this.PhoneNum = Phonenum;
        this.Comment = Commnet;
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

	public String getComment() {
		return Comment;
	}

	public void setComment(String comment) {
		Comment = comment;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}
  
}
