package com.GB.Users.model;

public class Users {
	private String UserId;
	private String UFirstName;
	private String ULastName;
	private String Uphone;
	private String UMail;
	private String UserRole;
	private String UPassword;
	
	
	public Users() {
		
	}
	
	public Users(String UserId, String UFirstName, String ULastName, String Uphone, String  UMail, String UserRole, String UPassword ) {
		super();
		this.UserId = UserId;
		this.UFirstName = UFirstName;
		this.ULastName = ULastName;
		this.Uphone = Uphone;
		this.UMail = UMail;
		this.UserRole = UserRole;
		this.UPassword=UPassword;
	}

	public String getUserId() {
		return UserId;
	}

	public void setUserId(String UserId) {
		this.UserId = UserId;
	}

	public String getUFirstName() {
		return UFirstName;
	}

	public void setUFirstName(String UFirstName) {
		this.UFirstName = UFirstName;
	}

	public String getULastName() {
		return ULastName;
	}

	public void setULastName(String ULastName) {
		this.ULastName = ULastName;
		
	}

	public String getUphone() {
		return Uphone;
	}

	public void setUphone(String Uphone) {
		this.Uphone = Uphone;
	}

	public String getUMail() {
		return UMail;
	}

	public void setUMail(String UMail) {
		this.UMail = UMail;
	}

	public String getUserRole() {
		return UserRole;
	}

	public void setUserRole(String UserRole) {
		this.UserRole = UserRole;
	}
	public String getUPassword() {
		return UPassword;
	}

	public void setUPassword(String UPassword) {
		this.UPassword = UPassword;
	}


}
