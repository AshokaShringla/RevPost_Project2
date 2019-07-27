package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.revature.entity.Users;
import com.revature.service.UsersService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/RegistrationController")
public class RegistrationController {
	  
	  @Autowired
	  public UsersService usersServiceImpl;
	  
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	  public ModelAndView addUser(@RequestBody Users user) {
		  System.out.println(user);
		  usersServiceImpl.createUsers(user);
		  return new ModelAndView("usersConfirmation", "firstname", user.getFirstName());
	  }
	}
