package com.myproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.model.Schule;

@Repository
public interface SchuleRepository extends JpaRepository<Schule, Long>{
//	@Query("SELECT s FROM Schule s where s.tietbd = 1 ORDER BY s.subject_id ASC")
	//@Query("SELECT s FROM Schule s where s.semestern=?1 ORDER BY s.subject_id ASC")

//	List<Schule> findAllASC(String hocky);
	@Query("SELECT s FROM Schule s where s.semestern= ?1 ORDER BY s.subject_id ASC")
	List<Schule> findAllASC(String hocky);
	
	@Query("SELECT s FROM Schule s where s.names = ?1 and s.semestern=?2 ORDER BY s.subject_id ASC")
	List<Schule> findByName(String name, String hocky);
	
	@Query("SELECT s FROM Schule s where s.lecturers_id = ?1 and s.thu = ?2 and s.semestern = ?3")
	List<Schule> listtbd(Long idl, String thu, String ky);
	
	@Query("SELECT s FROM Schule s where s.thu = ?1 and s.tietbd = ?2 and s.semestern = ?3")
	List<Schule> listr(String thu, Integer tietbd, String ky);

	
	@Query("SELECT s.malop FROM Schule s where s.semestern=?1")
	List<String> listMal(String hk);
}