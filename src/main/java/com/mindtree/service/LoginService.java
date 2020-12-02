
package com.mindtree.service;


import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.dto.LoginDto;
import com.mindtree.entity.Login;
import com.mindtree.repository.LoginRepository;
import com.mindtree.utils.PasswordUtils;
@Service
public class  LoginService {
	@Autowired
	private LoginRepository loginRepository ;
	Login login;
	
	private String password;
	private boolean flag;
	@Autowired
	private PasswordUtils passwordUtils;
	
	public Login loginCustomer(LoginDto Dto) {

		
		Optional<Login> c= loginRepository.findById(Dto.getEmailId());
		
		if(c.isPresent())	
			login=c.get();

		
		password = Dto.getPassword();
		flag = passwordUtils.verifyUserPassword(password, login.getPassword(), login.getSalt());
       
		
		if((login.getEmailId().equals(Dto.getEmailId()))&&(login.getRole().equals(Dto.getRole())) && (flag))
		{
			login.setPassword("");
			login.setSalt("");
			
		return login;
	}
		else {
			return null;
		}
	}

	
	
}


