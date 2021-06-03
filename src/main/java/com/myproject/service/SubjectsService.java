package com.myproject.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.model.Subjects;
import com.myproject.repository.SubjectsRepository;

@Service
public class SubjectsService {

	@Autowired
	private SubjectsRepository subjectsRepository;

	public Optional<Subjects> getSub(Long id) {
        return subjectsRepository.findById(id);
    }
}
