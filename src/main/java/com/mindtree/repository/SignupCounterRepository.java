package com.mindtree.repository;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.entity.SignupCounter;

public interface SignupCounterRepository extends CrudRepository<SignupCounter, Integer> {
	
}
