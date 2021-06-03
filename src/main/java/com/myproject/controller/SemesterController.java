package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.service.SemesterService;

@Controller
public class SemesterController {

	@Autowired
	SemesterService semesterService;
	
	@GetMapping("/listhk")
	@ResponseBody
	public List<String> getKyhoc(Model model) {
	    List<String> s = null;
		s = semesterService.getNameSe();
		return s;
	}
}
