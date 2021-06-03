package com.myproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.model.Semester;

@Repository
public interface SemesterRepository extends JpaRepository<Semester, Integer>{
	@Query("SELECT se.name FROM Semester se")
	List<String> listSemester();
}
