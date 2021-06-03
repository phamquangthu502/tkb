package com.myproject.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
//import javax.persistence.JoinColumns;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "tbl_room")
public class Room {
	@Id
	@Column(name = "name")
	private String name;
	
	@Column(name = "size")
	private int size;
	
	@Column(name = "thuchanh")
	private int th;

	public Room() {
		super();
	}

	public Room(String name, int size, int th) {
		super();
		this.name = name;
		this.size = size;
		this.th = th;
	}
	
	
	
}
