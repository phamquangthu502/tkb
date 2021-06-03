package com.myproject.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.model.Semester;
import com.myproject.repository.SemesterRepository;

@Service
public class SemesterService {
	@Autowired
	private SemesterRepository semesterRepository;
	
	public List<String> getNameSe(){
		return semesterRepository.listSemester();
	}
	public List<Semester> getNamexSe(){
		return (List<Semester>)semesterRepository.findAll();
	}
}
