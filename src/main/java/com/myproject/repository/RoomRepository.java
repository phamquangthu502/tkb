package com.myproject.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.myproject.model.Room;

@Repository
public interface RoomRepository extends JpaRepository<Room, Long>{
	@Query("SELECT r.name FROM Room r")
	List<String> listrr();
}
