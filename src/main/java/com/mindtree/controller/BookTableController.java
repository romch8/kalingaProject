package com.mindtree.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mindtree.entity.Bookings;
import com.mindtree.service.impl.BookTableServiceImpl;

@RestController
@RequestMapping(path="/table")
public class BookTableController
{
	@Autowired
	private BookTableServiceImpl bookTableServiceImpl;
	
	@CrossOrigin(origins="*")
	@PostMapping(path="/postbooking/{customerId}")
	public Bookings insert(@RequestBody Bookings book, @PathVariable String customerId)
	{
		bookTableServiceImpl.insertPostBook(book,customerId);
		return book;
	}
	
}
