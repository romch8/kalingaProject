package com.mindtree.service;

import com.mindtree.dto.ChangePasswordDTO;
import com.mindtree.dto.ForgotDTO;
import com.mindtree.dto.ForgotResponseDTO;
import com.mindtree.entity.OTP;

public interface ForgotService {
	ForgotResponseDTO getOtp(ForgotDTO forgotDto) throws Exception;

	ForgotResponseDTO verifyOtp(OTP otp);

	ForgotResponseDTO changePassword(ChangePasswordDTO changePasswordDTO);
	
}
