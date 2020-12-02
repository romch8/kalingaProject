package com.mindtree.dto;

public class ChangePasswordDTO {

	private String password;

	private String emailId;

	public String getPassword() {
		return password;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public ChangePasswordDTO() {
		/*
		 * Empty constructor for object creation
		 */
	}

}
