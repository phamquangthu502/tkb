package com.myproject.service;

import java.util.List;
import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.myproject.model.Schule;
import com.myproject.model.Subjects;
import com.myproject.repository.SchuleRepository;

@Service
public class SchuleService{
	
	@Autowired
	private SchuleRepository schuleRepository;

	public List<Schule> findAll(String hocky) {
		return (List<Schule>) schuleRepository.findAllASC(hocky);
	}

	
	public List<Schule> getByName(String name, String hocky) {
		return (List<Schule>) schuleRepository.findByName(name, hocky);
	}
	
	public Optional<Schule> getSchule(Long id) {
        return schuleRepository.findById(id);
    }
	public List<Schule> listlt(Long idl, String thu, String ky) {
		return (List<Schule>) schuleRepository.listtbd(idl, thu, ky);
	}
	public List<Schule> getr(String thu, Integer tietbd, String ky) {
		return (List<Schule>) schuleRepository.listr(thu, tietbd, ky);
	}

	public Schule save(Schule sc) {
		return schuleRepository.save(sc);
	}
	
	public Schule update(Schule sc) {
		return schuleRepository.save(sc);
	}
	
	public void deleteSchule(Long id) {
		schuleRepository.deleteById(id);
	}
	
	public List<String> getMal(String hk) {
        return schuleRepository.listMal(hk) ;
    }
}
