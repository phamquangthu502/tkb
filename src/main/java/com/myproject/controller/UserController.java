package com.myproject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.myproject.model.User;
import com.myproject.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping("/checkLog")
	public String Login(@RequestParam(value = "iduser") String username, @RequestParam(value = "passwords") String password, Model model) {
		//model.addAttribute("listSchules", schuleService.findAll());
		
		User us = userService.getUser(username, password);
		if(us!=null) {
			model.addAttribute("user", username);
			return "indexx";
		}
		model.addAttribute("invalid", true);
		return "login";
	}
}
