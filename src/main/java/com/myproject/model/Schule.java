package com.myproject.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
@Table(name = "tbl_schule")
public class Schule {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "semester_name")
	private String semestern;
	
	@Column(name = "subject_id")
	private Long subject_id;
	
	@Column(name = "sub_name")
	private String names;  
	
	@Column(name = "lecturers_id")
	private Long lecturers_id;
	@Column(name = "lecs_name")
	private String namel;  
	
	@Column(name = "nhom")
	private int nhom;
	
	@Column(name = "tth")
	private int tth;
	@Column(name = "stc")
	private int stc;
	@Column(name = "malop")
	private String malop;
	@Column(name = "siso")
	private int siso;
	@Column(name = "thu")
	private String thu;
	@Column(name = "tietbd")
	private int tietbd;
	@Column(name = "sotiet")
	private int sotiet;	
	@Column(name = "room_name")
	private String namer;

	public Schule() {
		super();
	}

	public Schule(Long id, String semestern, Long subject_id, String names, Long lecturers_id, String namel, int nhom,
			int tth, int stc, String malop, int siso, String thu, int tietbd, int sotiet, String namer) {
		super();
		this.id = id;
		this.semestern = semestern;
		this.subject_id = subject_id;
		this.names = names;
		this.lecturers_id = lecturers_id;
		this.namel = namel;
		this.nhom = nhom;
		this.tth = tth;
		this.stc = stc;
		this.malop = malop;
		this.siso = siso;
		this.thu = thu;
		this.tietbd = tietbd;
		this.sotiet = sotiet;
		this.namer = namer;
	}

	public Long getId() {
		return id;
	}

	public String getSemestern() {
		return semestern;
	}

	public Long getSubject_id() {
		return subject_id;
	}

	public String getNames() {
		return names;
	}

	public Long getLecturers_id() {
		return lecturers_id;
	}

	public String getNamel() {
		return namel;
	}

	public int getNhom() {
		return nhom;
	}

	public int getTth() {
		return tth;
	}

	public int getStc() {
		return stc;
	}

	public String getMalop() {
		return malop;
	}

	public int getSiso() {
		return siso;
	}

	public String getThu() {
		return thu;
	}

	public int getTietbd() {
		return tietbd;
	}

	public int getSotiet() {
		return sotiet;
	}

	public String getNamer() {
		return namer;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public void setSemestern(String semestern) {
		this.semestern = semestern;
	}

	public void setSubject_id(Long subject_id) {
		this.subject_id = subject_id;
	}

	public void setNames(String names) {
		this.names = names;
	}

	public void setLecturers_id(Long lecturers_id) {
		this.lecturers_id = lecturers_id;
	}

	public void setNamel(String namel) {
		this.namel = namel;
	}

	public void setNhom(int nhom) {
		this.nhom = nhom;
	}

	public void setTth(int tth) {
		this.tth = tth;
	}

	public void setStc(int stc) {
		this.stc = stc;
	}

	public void setMalop(String malop) {
		this.malop = malop;
	}

	public void setSiso(int siso) {
		this.siso = siso;
	}

	public void setThu(String thu) {
		this.thu = thu;
	}

	public void setTietbd(int tietbd) {
		this.tietbd = tietbd;
	}

	public void setSotiet(int sotiet) {
		this.sotiet = sotiet;
	}

	public void setNamer(String namer) {
		this.namer = namer;
	}
	
}
