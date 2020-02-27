package com.codingdojo.EventFree.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.EventFree.models.Event;
import com.codingdojo.EventFree.models.User;

@Repository
public interface EventRepository extends CrudRepository<Event,Long>{
	List<Event>findAll();
	List<Event>findByUsersContaining(User user);
	List<Event>findByUsersNotContaining(User user);
	List<Event>findEventsByUsersNotContaining(User creator);
}
