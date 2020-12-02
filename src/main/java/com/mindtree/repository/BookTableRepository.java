package com.mindtree.repository;

import org.springframework.data.repository.CrudRepository;

import com.mindtree.entity.Bookings;


public interface BookTableRepository extends CrudRepository<Bookings, Integer>
{
}