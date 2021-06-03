package com.myproject.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myproject.model.Lecturers;

@Repository
public interface LecturersRepository extends JpaRepository<Lecturers, Long>{

}
