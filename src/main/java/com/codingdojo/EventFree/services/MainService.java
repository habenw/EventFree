package com.codingdojo.EventFree.services;

import java.util.Optional;

import org.mindrot.jbcrypt.BCrypt;

import com.codingdojo.EventFree.models.User;
import com.codingdojo.EventFree.repositories.EventRepository;
import com.codingdojo.EventFree.repositories.UserRepository;


public class MainService {
	private final UserRepository userRepository;
    private final EventRepository eventRepository;
    
    public MainService(UserRepository userRepository,EventRepository eventRepository) {
        this.userRepository = userRepository;
        this.eventRepository=eventRepository;
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
}