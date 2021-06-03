package com.myproject.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.service.RoomService;

@Controller
public class RoomController {

	@Autowired
	RoomService roomService;
	
	@GetMapping("/listrr")
	@ResponseBody
	public List<String> getRoom(Model model) {
	    List<String> s = null;
		s = roomService.getListRoom();
		return s;
	}
}
