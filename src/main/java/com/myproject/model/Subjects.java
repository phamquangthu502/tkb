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

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbl_subjects")
public class Subjects {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "name_sub")
	private String name_sub;
	
	@Column(name = "tinChi")
	private String tinchi;
	
	@Column(name = "thuchanh")
	private int thuchanh;

	public Subjects() {
		super();
	}

	public Subjects(Long id, String name_sub, String tinchi, int thuchanh) {
		super();
		this.id = id;
		this.name_sub = name_sub;
		this.tinchi = tinchi;
		this.thuchanh = thuchanh;
	}

	public Long getId() {
		return id;
	}

	public String getName_sub() {
		return name_sub;
	}

	public String getTinchi() {
		return tinchi;
	}

	public int getThuchanh() {
		return thuchanh;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setName_sub(String name_sub) {
		this.name_sub = name_sub;
	}

	public void setTinchi(String tinchi) {
		this.tinchi = tinchi;
	}

	public void setThuchanh(int thuchanh) {
		this.thuchanh = thuchanh;
	}

	

	

	
}
