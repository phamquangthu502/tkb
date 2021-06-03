package com.myproject.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.myproject.model.Schule;
import com.myproject.model.Subjects;
import com.myproject.service.SchuleService;

import com.myproject.dto.ServiceResponse;

@Controller
public class SchuleController {
	
	
	@Autowired
	SchuleService schuleService;
	
	@GetMapping("/")
	public String viewHomePage(Model model) {
		//model.addAttribute("listSchules", schuleService.findAll());
		return "index";
	}
	
	@GetMapping("/login")
	public String viewLogin(Model model) {
		//model.addAttribute("listSchules", schuleService.findAll());
		return "login";
	}
	@GetMapping("/logout")
	public String Logout(Model model) {
		//model.addAttribute("listSchules", schuleService.findAll());
		return "index";
	}
	@GetMapping("/lenlich")
	public String viewLenlich(Model model) {
		return "lenlich";
	}
	
	@GetMapping("/search")
	public String viewHomepage(@RequestParam(value = "keyword") String namex, @RequestParam(value = "inpkyhoc") String hocky, Model model) {
		List<Schule> schules = null;
		if(namex!="") {
			schules = schuleService.getByName(namex,hocky);
		}
		else schules = schuleService.findAll(hocky);
		model.addAttribute("listSchules", schules);
		model.addAttribute("keyword", namex);
		model.addAttribute("inpkyhoc", hocky);
		return "lenlich";
	}
	
	@RequestMapping(value = "/addSchule", method = RequestMethod.POST)
	public void saveSchule(@RequestBody Schule sc) {
		schuleService.save(sc);
	}

	@RequestMapping(value = "/saveSchule", method = RequestMethod.PUT)
	public String updateSchule(@RequestBody Schule sc) {
		schuleService.update(sc);
		
		return "redirect:/";
		
	}

	@GetMapping("/schule")
	@ResponseBody
	public Optional<Schule> getSchuleById(Long id, Model model) {
		return schuleService.getSchule(id);
	}
	
	@GetMapping("/listtbd")
	@ResponseBody
	public List<Schule> getTietbd(Long idl, String thu, String ky, Model model) {
	    List<Schule> s = null;
		s = schuleService.listlt(idl, thu, ky);
		return s;
	}
	
	@GetMapping("/malop")
	@ResponseBody
	public String checkMalop(String id, String ky, Model model) {
		try {
			String malop = id;
		    String hk = ky;
			List<String> s = null;
			s = schuleService.getMal(hk);
			for(int i=0; i<s.size(); ++i) {
				if(malop.equals(s.get(i))) {
					return malop;
				}
			}
			
		} catch (Exception e) {
		}
		return null;
	}
	
	@GetMapping("/listr")
	@ResponseBody
	public List<Schule> getListRoom(String thu, Integer tietbd, String ky, Model model) {
	    List<Schule> s = null;
		s = schuleService.getr(thu, tietbd, ky);
		return s;
	}

	@RequestMapping(value = "/delete", method = { RequestMethod.GET,RequestMethod.POST,RequestMethod.PUT})
	public void deleteSchule( Long id) {
		schuleService.deleteSchule(id);
	}
	
}
