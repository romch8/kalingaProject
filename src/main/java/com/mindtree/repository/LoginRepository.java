package com.mindtree.repository;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.entity.Login;

public interface LoginRepository extends CrudRepository<Login, String> {
}
