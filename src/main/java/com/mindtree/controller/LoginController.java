package com.mindtree.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.dto.ChangePasswordDTO;
import com.mindtree.dto.ForgotDTO;
import com.mindtree.dto.ForgotResponseDTO;
import com.mindtree.dto.LoginDto;
import com.mindtree.entity.Login;
import com.mindtree.entity.OTP;
import com.mindtree.service.ForgotService;
import com.mindtree.service.LoginService;

@RestController
@RequestMapping(path = "/customer")

public class LoginController {
	@Autowired
	private LoginService loginService;

	@Autowired
	private ForgotService forgotService;

	@CrossOrigin
	@PostMapping(path = "/customerlogin")
	public Login loginCustomer(@RequestBody LoginDto dto) {
		return loginService.loginCustomer(dto);
	}

	@CrossOrigin
	@PostMapping(path = "/forgot")
	private ForgotResponseDTO getCustomer(@RequestBody ForgotDTO forgotDto) {
		try {
			return forgotService.getOtp(forgotDto);

		} catch (Exception e) {
			e.printStackTrace();
			return new ForgotResponseDTO("failure",
					"Unable to find the user. Please verify details or try again later.",forgotDto.getEmailId());
		}
	}

	@CrossOrigin
	@PostMapping(path = "/verify")
	private ForgotResponseDTO verify(@RequestBody OTP otp) {
		return forgotService.verifyOtp(otp);
	}

	@CrossOrigin
	@PostMapping(path = "/changePassword")
	private ForgotResponseDTO changePassword(@RequestBody ChangePasswordDTO changePasswordDTO) {
		return forgotService.changePassword(changePasswordDTO);
	}

}
