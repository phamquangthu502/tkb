package com.myproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.model.Lecturers;
import com.myproject.repository.LecturersRepository;

@Service
public class LecturersService {
	@Autowired
	private LecturersRepository lecturersRepository;
	
	public Optional<Lecturers> getLec(Long id) {
        return lecturersRepository.findById(id);
    }
}
