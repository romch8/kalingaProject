package com.mindtree.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.entity.Vendor;

public interface SearchRepository extends CrudRepository<Vendor, String> {
	// @Query(value = "SELECT FROM todos t WHERE t.title = 'title'", nativeQuery =
	// true)

	List<Vendor> findByVendorAddressCity(String city);

}
