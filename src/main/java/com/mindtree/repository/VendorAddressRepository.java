package com.mindtree.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.mindtree.entity.VendorAddress;

public interface VendorAddressRepository extends CrudRepository<VendorAddress, Integer> {

	@Query(value = "SELECT   distinct city FROM vendor_address   ", nativeQuery = true)
	List<String> findcitynames();

}
