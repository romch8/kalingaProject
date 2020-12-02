package com.mindtree.service.impl;

import java.util.Optional;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dto.ChangePasswordDTO;
import com.mindtree.dto.ForgotDTO;
import com.mindtree.dto.ForgotResponseDTO;
import com.mindtree.entity.Customer;
import com.mindtree.entity.Login;
import com.mindtree.entity.OTP;
import com.mindtree.repository.LoginRepository;
import com.mindtree.repository.OTPRepository;
import com.mindtree.service.ForgotService;
import com.mindtree.utils.PasswordUtils;
import com.mindtree.utils.SignupUtils;

@Service
public class ForgotServiceImpl implements ForgotService {

	private Customer customer;

	private OTP otp;

	private Login login;

	private SignupUtils signupUtils = new SignupUtils();

	@Autowired
	private LoginRepository loginRepository;

	@Autowired
	private OTPRepository otpRepository;

	private PasswordUtils passwordUtils = new PasswordUtils();

	String success = "success";

	String failure = "failure";

	@Override
	public ForgotResponseDTO getOtp(ForgotDTO forgotDto) throws Exception {

		Optional<Login> optionLogin;
		optionLogin = loginRepository.findById(forgotDto.getEmailId());
		ForgotResponseDTO response = new ForgotResponseDTO();
		if (optionLogin.isPresent()) {
			customer = new Customer();
			customer.setEmailId(forgotDto.getEmailId());

			try {
				otp = signupUtils.sendMail(forgotDto.getEmailId(), "forgot");
			} catch (MessagingException e) {
				response.setStatus(failure);
				response.setMessage(
						"Unable to send verification email. Please try again later!!");
				return response;
			}
			otpRepository.save(otp);
			response.setStatus(success);
			response.setEmail(customer.getEmailId());
			response.setMessage("OTP sent");
			return response;
		} else {
			response.setStatus(failure);
			response.setMessage("It seems you didn't have an account! Register now!!");
			response.setEmail(forgotDto.getEmailId());
			return response;
		}
	}

	public ForgotResponseDTO verifyOtp(OTP otpIncoming) {
		otp = otpRepository.findByEmailId(otpIncoming.getEmailId());

		if (otp != null && otp.getOtp().equals(otpIncoming.getOtp())) {
			otpRepository.deleteById(otp.getId());
			return new ForgotResponseDTO(success, "Successfully verified. Please Change Password.",
					otpIncoming.getEmailId());
		} else {
			return new ForgotResponseDTO(failure, "Verification failed! Try again later!!", otpIncoming.getEmailId());
		}
	}

	public ForgotResponseDTO changePassword(ChangePasswordDTO changePasswordDTO) {
		Optional<Login> optionLogin;
		optionLogin = loginRepository.findById(changePasswordDTO.getEmailId());
		if (optionLogin.isPresent()) {
			login = optionLogin.get();
			String password = changePasswordDTO.getPassword();

			String salt = passwordUtils.getSalt(30);

			String encryptedPassword = passwordUtils.generateSecurePassword(password, salt);

			login.setPassword(encryptedPassword);
			login.setSalt(salt);
			loginRepository.save(login);
			return new ForgotResponseDTO(success, "New Password Updated Successfully. Login!",
					changePasswordDTO.getEmailId());
		} else {
			return new ForgotResponseDTO(failure, "Failed to Update New Password ", changePasswordDTO.getEmailId());
		}

	}
}
