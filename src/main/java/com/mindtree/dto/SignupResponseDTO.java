package com.mindtree.dto;

public class SignupResponseDTO {
	
	private String email;
	
	private String status;
	
	private String message;
	
	private String otp;
	
	public SignupResponseDTO() {
	}
	
	public SignupResponseDTO(String status, String message, String email) {
		this.status = status;
		this.message = message;
		this.email = email;
	}

	public String getOtp() {
		return otp;
	}

	public void setOtp(String otp) {
		this.otp = otp;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
