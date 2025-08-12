package com.portal.jobportal.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.portal.jobportal.entity.Users;
import com.portal.jobportal.entity.UsersType;
import com.portal.jobportal.services.UsersTypeService;



@Controller
public class UsersController {
		private final UsersTypeService usersTypeService;
		@Autowired
		public UsersController(UsersTypeService usersTypeService) {
			this.usersTypeService=usersTypeService;
		}
		@GetMapping("/register")
		public String register(Model model) {
			List<UsersType> usersType=usersTypeService.getAll();
			model.addAttribute("getAllTypes",usersType);
			model.addAttribute("user",new Users());
			return "register";
			
		}
}
