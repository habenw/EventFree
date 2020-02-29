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
	public String loginReg(@ModelAttribute("user") User user) {
		return "loginReg.jsp";
	}
	@GetMapping("/register")
	public String reg(@ModelAttribute("user") User user) {
		return "redirect:/";
	}
	@PostMapping("/register")
	public String reg(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		userValid.validate(user, result);
		if(result.hasErrors()) {
			return "loginReg.jsp";
		} else {
			User newUser=mainServ.registerUser(user);
			session.setAttribute("user_id", newUser.getId());
			return "redirect:/events";
		}
	}
	@GetMapping("/login")
	public String login() {
		return "redirect:/";
	}
	@PostMapping("/login")
	public String processLogin(@ModelAttribute("user") User user, @RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
		if(!mainServ.authenticateUser(email,password)) {
			model.addAttribute("invalid", "Your credentials are not valid.");
			return "loginReg.jsp";
		}
		User thisUser = mainServ.findByEmail(email);
		session.setAttribute("user_id", thisUser.getId());
		return "redirect:/events";
	}
	@GetMapping("/events")
	public String dashboard(Model model, HttpSession session) {
		if(session.getAttribute("user_id") == null) {
			return "redirect:/login";
		}
		List<Event> events = mainServ.allEvents();
		model.addAttribute("allEvents", events);
		List<User> users = mainServ.allUsers();
		model.addAttribute("allUsers", users);
		User user = mainServ.findUserById((Long) session.getAttribute("user_id") );
		model.addAttribute("user", user);
		return "dashboard.jsp";
	}
	@GetMapping("/myEvents")
	public String eventsDash(Model model, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/login";
		} else {
			Long userId = (Long) session.getAttribute("user_id");
			User user = mainServ.findUserById(userId);
			List<Event> events = user.getCreated_events();
			model.addAttribute("user", user);
			model.addAttribute("allMyEvents", events);
			return "myEvents.jsp";
		}
	}
	@GetMapping("/profile")
	public String profile(Model model, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/login";
		} else {
			Long userId = (Long) session.getAttribute("user_id");
			User user = mainServ.findUserById(userId);
			model.addAttribute("user", user);
			return "profile.jsp";
		}
	}
	@PutMapping("/update_profile")
	public String updateProfile(@Valid @ModelAttribute("user") User user, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "profile.jsp";
		} else {
			mainServ.updateUser(user);
			return "redirect:/profile";
		}
	}
	@GetMapping("/editprofile")
	public String editProfile(Model model, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/login";
		} else {
			Long userId = (Long) session.getAttribute("user_id");
			User user = mainServ.findUserById(userId);
			model.addAttribute(user);
			return "editProfile.jsp";
		}
	}
	@GetMapping("/friends")
	public String friends(Model model, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/login";
		} else {
			Long userId = (Long) session.getAttribute("user_id");
			User user = mainServ.findUserById(userId);
			model.addAttribute("user", user);
			return "friends.jsp";
		}
	}
	@GetMapping("/friendsevents")
	public String friendsEvents(Model model, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/login";
		} else {
			Long userId = (Long) session.getAttribute("user_id");
			User user = mainServ.findUserById(userId);
			model.addAttribute("user", user);
			return "friendsEvents.jsp";
		}
	}
//	@GetMapping("/otherevents")
//	public String otherEvents(Model model, HttpSession session) {
//		if(session.getAttribute("user_id")==null) {
//			return "redirect:/login";
//		} else {
//			Long userId = (Long) session.getAttribute("user_id");
//			User user = mainServ.findUserById(userId);
//			List<User> events = mainServ.findOtherEvents(user);
//			model.addAttribute("user", user);
//			model.addAttribute("allOtherEvents", events);
//			return "otherevents.jsp";
//		}
//	}
	@PutMapping("/attend")
	public String attendEvent(@PathVariable("id") Long userId, @RequestParam("events") Long eventId) {
		User user = mainServ.findUserById(userId);
		Event event = mainServ.findEvent(eventId);
		event.getAttendees().add(user);
		mainServ.createEvent(event);
		return "redirect:/events";
	}
	@PutMapping("/leave")
	public String leaveEvent(@PathVariable("id") Long userId, @RequestParam("events") Long eventId) {
		User user = mainServ.findUserById(userId);
		Event event = mainServ.findEvent(eventId);
		event.getAttendees().remove(user);
		mainServ.createEvent(event);
		return "redirect:/events";
	}
	@PutMapping("/attend/{id}")
	public String attendThisEvent(@PathVariable("id") Long userId, @RequestParam("events") Long eventId) {
		User user = mainServ.findUserById(userId);
		Event event = mainServ.findEvent(eventId);
		event.getAttendees().add(user);
		mainServ.createEvent(event);
		return "redirect:/events/{id}";
	}
	@PutMapping("/leave/{id}")
	public String leaveThisEvent(@PathVariable("id") Long userId, @RequestParam("events") Long eventId) {
		User user = mainServ.findUserById(userId);
		Event event = mainServ.findEvent(eventId);
		event.getAttendees().remove(user);
		mainServ.createEvent(event);
		return "redirect:/events/{id}";
	}
	@GetMapping("/events/new")
	public String newEvent(@ModelAttribute("new") Event event, Model model, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/login";
		} else {
			Long userId = (Long) session.getAttribute("user_id");
			User user = mainServ.findUserById(userId);
			model.addAttribute("user", user);
			return "eventNew.jsp";
		}
	}
	@PostMapping("/events/new")
	public String makeNewEvent(@Valid @ModelAttribute("new") Event event, BindingResult result, HttpSession session) { 
		if(result.hasErrors()) {
			return "eventNew.jsp";
		} else {
			mainServ.createEvent(event);
			return "redirect:/events/"+event.getId();
		}
	}
	@GetMapping("/events/{id}")
	public String showEvent(@PathVariable("id") Long id, Model model, HttpSession session) {
		Event thisEvent = mainServ.findEvent(id);
		model.addAttribute("event", thisEvent);
		return "show.jsp";
	}
	@GetMapping("/events/{id}/edit")
	public String editevent(@PathVariable("id") Long id, Model model, HttpSession session) {
		if(session.getAttribute("user_id")==null) {
			return "redirect:/login";
		} else {
//			Long userId = (Long) session.getAttribute("user_id");
//			User user = mainServ.findUserById(userId);
			Event event = mainServ.findEvent(id);
			User creator = mainServ.findEventCreator(id);
//			model.addAttribute("user", user);
			model.addAttribute("event", event);
			model.addAttribute("creator", creator);
      return "edit.jsp";
		}
	}
	@PutMapping("/events/{id}/edit")
	public String updateEvent(@Valid @ModelAttribute("event") Event event, BindingResult result, Model model) {
		if(result.hasErrors()) {
			return "edit.jsp";
		} else {
			mainServ.updateEvent(event);
			return "redirect:/events/"+event.getId();
		}
	}
	@GetMapping("/events/search")
	public String searchEvent(@RequestParam(value="search")String search, Model model) {
		List<Event> results = mainServ.findEventByName(search);
		model.addAttribute("results", results);
		return "eventSearch.jsp";
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
