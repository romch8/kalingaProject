package com.mindtree.repository;
import org.springframework.data.repository.CrudRepository;
import com.mindtree.entity.Customer;

public interface CustomerRepository extends CrudRepository<Customer, String> {
	
}
