package com.codingdojo.EventFree.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.EventFree.models.Event;
import com.codingdojo.EventFree.models.User;

@Repository
public interface EventRepository extends CrudRepository<Event,Long>{
	List<Event>findAll();
	List<User>findByAttendeesNotContaining(User user);
	List<User>findEventsByAttendeesNotContaining(User creator);
	List<Event>findByCreatorContaining(Event creator);
	List<Event> findByNameIgnoreCaseContaining(String search);

}