package com.mindtree.repository;

import org.springframework.data.repository.CrudRepository;
import com.mindtree.entity.OTP;

public interface OTPRepository extends CrudRepository<OTP, Integer> {
	
	public OTP findByEmailId(String emailId);

}