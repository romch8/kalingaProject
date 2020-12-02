package com.mindtree.service;

import com.mindtree.entity.Bookings;

public interface BookTableService 
{
	void insertPostBook(Bookings book, String customerId);

}
