package com.myproject.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.model.Lecturers;
import com.myproject.service.LecturersService;

@Controller
public class LecturersController {

	@Autowired
	LecturersService lecturersService;
	
	@GetMapping("/lecturer")
	@ResponseBody
	public Optional<Lecturers> getNameLecturer(Long id, Model model) {
		Optional<Lecturers> l = null;
		l = lecturersService.getLec(id);
		return l;
	}
}
