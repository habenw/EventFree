package com.codingdojo.EventFree.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.EventFree.models.User;
import com.codingdojo.EventFree.services.MainService;
import com.codingdojo.EventFree.validators.UserValidator;
	
@Controller
public class MainController {

	private final MainService mainServ;
	private final UserValidator userValid;
	
	public MainController(MainService mainServ, UserValidator userValid) {
		this.mainServ = mainServ;
		this.userValid = userValid;
	}
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) {
		return "loginReg.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValid.validate(user, result);
		if(result.hasErrors()) {
			return "loginReg.jsp";
		} else {
			User newUser=mainServ.registerUser(user);
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/ideas";
		}
	}
	@GetMapping("/login")
	public String gohome() {
		return "redirect:/";
	}
	@PostMapping("/login")
	public String login(@ModelAttribute("user") User user, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		if(!mainServ.authenticateUser(email, password)) {
			model.addAttribute("invalid", "Your credentials are invalid.");
			return "index.jsp";
		} else {
			User thisUser = mainServ.findByEmail(email);
			session.setAttribute("user_id", thisUser.getId());
			return "redirect:/ideas";
		}
	}
}
