package com.mindtree.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mindtree.entity.Vendor;

public interface VendorRepository extends CrudRepository<Vendor, String> {

	@Modifying
	@Query(value = "update vendor u set u.num_of_tables = u.num_of_tables-1 where u.vendor_id = ?", nativeQuery = true)
	void changetime(String vendor_id);
}
