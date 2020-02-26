package com.codingdojo.EventFree.validators;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import com.codingdojo.EventFree.models.User;
import com.codingdojo.EventFree.services.MainService;



@Component
public class UserValidator implements Validator{
private final MainService mainService;
	
	public UserValidator(MainService mainService) {
		this.mainService = mainService;
	}
    
    
    @Override
    public boolean supports(Class<?> clazz) {
        return User.class.equals(clazz);
    }
    @Override
    public void validate(Object target, Errors errors) {
        User user = (User) target;
        
        if (!user.getPasswordConfirmation().equals(user.getPassword())) {    
            errors.rejectValue("passwordConfirmation", "Match");
        } 
        if(mainService.checkEmail(user.getEmail()) == true) {
    		errors.rejectValue("duplicate","Duplicate");
		}
	}
}		


