package com.hcl.search_update.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.hcl.search_update.model.UserEntity;
import com.hcl.search_update.service.LoginService;

@Controller 

public class LoginController {
	@Autowired
	LoginService service;
	private static Logger logger = LoggerFactory.getLogger(LoginController.class);

	//Get login page 
	@RequestMapping(value="/login", method = RequestMethod.GET)
	public String showLoginPage(ModelMap model){
		return "login";
	}
	
	//Find User and login via id 	
	@RequestMapping(value="/login", method = RequestMethod.POST)
	public String searchUser(@ModelAttribute(name="id") Long id){
		if(service.searchID(id)) {
			logger.info("inside searchID method");		
		    	return "update";
		    }
		    return null;
	}	
	//Get Update page
	@RequestMapping(value="/update", method = RequestMethod.GET)
	public String showUpdatePage(ModelMap model){
		return "update";
	}
	
	//Update User and login via id 	
		@RequestMapping(value="/update", method = RequestMethod.POST)
		public String updateUser( @ModelAttribute UserEntity user){

				logger.info("inside update method");
				service.updateUser(user.getName(),user.getPassword());	
				return "welcome";

		}
}
