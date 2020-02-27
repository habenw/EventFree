package com.codingdojo.EventFree.controllers;

import java.util.List;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.codingdojo.EventFree.models.Event;
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
		return "index.jsp";
	}
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValid.validate(user, result);
		if(result.hasErrors()) {
			return "index.jsp";
		} else {
			User newUser=mainServ.registerUser(user);
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/events";
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
			return "redirect:/events";
		}
	}
	@GetMapping("/events")
	public String eventsDash(Model model, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/login";
		} else {
			Long userId = (Long) session.getAttribute("user_id");
			User user = mainServ.findUserById(userId);
			List<Event> events = mainServ.allEvents();
			model.addAttribute("user", user);
			model.addAttribute("allEvents", events);
			return "events.jsp";
		}
	}
	@GetMapping("/events/new")
	public String newevent(@ModelAttribute("event") Event event, Model model, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/login";
		} else {
			Long userId = (Long) session.getAttribute("user_id");
			User user = mainServ.findUserById(userId);
			model.addAttribute("user", user);
			return "new.jsp";
		}
	}
	@PostMapping("events/new")
	public String makeNewEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, HttpSession session) { 
		if(result.hasErrors()) {
			return "redirect:/events/new";
		} else {
			mainServ.createEvent(event);
			return "redirect:/events/"+event.getId();
		}
	}
	@GetMapping("events/{event.id}")
	public String showevent(@PathVariable("event.id") Long id, Model model, HttpSession session) {
		Event thisEvent = mainServ.findEvent(id);
		model.addAttribute("event", thisEvent);
		return "show.jsp";
	}
	@GetMapping("events/{id}/edit")
	public String editevent(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/login";
		} else {
			Long userId = (Long) session.getAttribute("user_id");
			User user = mainServ.findUserById(userId);
			Event event = mainServ.findEvent(id);
			User creator = mainServ.findEventCreator(id);
			model.addAttribute("user", user);
			model.addAttribute("event", event);
			model.addAttribute("creator", creator);
			if(user.getId()!=creator.getId()) {
				model.addAttribute("invalid", "You may not edit this event.");
				return "redirect:/events/"+event.getId();
			} else {
				return "edit.jsp";
			}
		}
	}
	@PutMapping("events/{id}/edit")
	public String updateevent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			mainServ.updateEvent(event);
			return "redirect:/events/"+event.getId();
		}
	}
	@GetMapping("/delete/{id}")
	public String destroy(@PathVariable("id") Long id) {
		mainServ.deleteEvent(id);
		return "redirect:/events";
	}
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.removeAttribute("user_id");
		return "redirect:/";
	}
}
