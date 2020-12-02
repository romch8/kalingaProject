package com.mindtree.service.impl;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mindtree.entity.Bookings;
import com.mindtree.repository.BookTableRepository;
import com.mindtree.repository.VendorRepository;
import com.mindtree.service.BookTableService;

@Service
public class BookTableServiceImpl implements BookTableService
{
	
	@Autowired
	private BookTableRepository booktableRepository;
	@Autowired
	private VendorRepository vendorRepo;
	@Transactional
	public void insertPostBook(Bookings book, String customerId)
	{
		booktableRepository.save(book);
		vendorRepo.changetime(customerId);
	}

}
	