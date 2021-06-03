package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.model.Subjects;

@Repository
public interface SubjectsRepository extends JpaRepository<Subjects, Long>{

}
