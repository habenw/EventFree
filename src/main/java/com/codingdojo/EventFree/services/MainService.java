package com.codingdojo.EventFree.services;

import java.util.List;
import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import com.codingdojo.EventFree.models.Event;
import com.codingdojo.EventFree.models.User;
import com.codingdojo.EventFree.repositories.EventRepository;
import com.codingdojo.EventFree.repositories.UserRepository;

@Service
public class MainService {
	private final UserRepository userRepository;
    private final EventRepository eventRepository;
    
    public MainService(UserRepository userRepository,EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository=eventRepository;
    }
	public List<User> allUsers() {
		return userRepository.findAll();
	}
	public List<Event> allEvents() {
		return eventRepository.findAll();
	}
	
    public User registerUser(User user) {
        String hashed = BCrypt.hashpw(user.getPassword(), BCrypt.gensalt());
        user.setPassword(hashed);
        return userRepository.save(user);
    }
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
    public boolean checkEmail(String email) {
    	User user = this.findByEmail(email);
    	if(user == null) {
    		return false;
    	}
    	return true;
    }
   public User findUserById(Long id) {
    	Optional<User> u = userRepository.findById(id);
    	
    	if(u.isPresent()) {
            return u.get();
    	} else {
    	    return null;
    	}
   }    
   public boolean authenticateUser(String email, String password) {
       User user = userRepository.findByEmail(email);
       if(user == null) {
           return false;
       } else {
           if(BCrypt.checkpw(password, user.getPassword())) {
               return true;
           } else {
               return false;
           }
       }
   }
   public Event createEvent(Event event) {
   	return eventRepository.save(event);
   }
   public Event findEvent(Long id) {
   	Event event = eventRepository.findById(id).orElse(null);
   	if(event!=null) {
   		return event;
   	}
   	return null;
   }
   public User findEventCreator(Long id) {
   	Event event = eventRepository.findById(id).orElse(null);
   	if(event!=null) {
   		return event.getCreator();
   	}
   	return null;
   }
   public Event updateEvent(Event event) {
   	if(event!=null) {
   		return eventRepository.save(event);
   	}
   	return null;
   }
   public void deleteEvent(Long id) {
   	eventRepository.deleteById(id);
   }
}