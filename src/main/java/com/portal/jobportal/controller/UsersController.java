package com.portal.jobportal.controller;

import java.util.List;
import java.util.Optional;

import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.portal.jobportal.entity.Users;
import com.portal.jobportal.entity.UsersType;
import com.portal.jobportal.services.UsersService;
import com.portal.jobportal.services.UsersTypeService;

import jakarta.validation.Valid;



@Controller
public class UsersController {
	    Logger log;
		private final UsersTypeService usersTypeService;
		private final UsersService usersService;
		@Autowired
		public UsersController(UsersTypeService usersTypeService,UsersService usersService) {
			this.usersTypeService=usersTypeService;
			this.usersService=usersService;
			
		}
		@GetMapping("/register")
		public String register(Model model) {
			List<UsersType> usersType=usersTypeService.getAll();
			System.out.println("****Inside Usercontroller service******");
			model.addAttribute("getAllTypes",usersType);
			model.addAttribute("user",new Users());
			return "register";
			
		}
		@PostMapping("/register/new")
		public String userRegistration(@Valid Users users,Model model) {
			Optional<Users> optionalUsers= usersService.getUserByEmail(users.getEmail());
			 if(optionalUsers.isPresent()) {
				 model.addAttribute("error","Email already registered,try to login or register with other email");
				 List<UsersType> usersType=usersTypeService.getAll();
					System.out.println("****Duplicate Email already present******");
					model.addAttribute("getAllTypes",usersType);
					model.addAttribute("user",new Users());
					return "register";
			 }
			usersService.addNew(users);
			return "dashboard";
		}
}
