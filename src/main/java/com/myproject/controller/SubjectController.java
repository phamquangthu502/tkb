package com.myproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.model.Subjects;
import com.myproject.service.SubjectsService;

@Controller
public class SubjectController {

	@Autowired
	SubjectsService subjectsService;
	
	@GetMapping("/subject")
	@ResponseBody
	public Optional<Subjects> getNameSubject(Long id, Model model) {
		Optional<Subjects> s = null;
		s = subjectsService.getSub(id);
		return s;
	}
}
