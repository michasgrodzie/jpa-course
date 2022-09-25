package com.nauka.jpa.hibernate.demo.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;



@Entity
public class Passport extends Object {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String number;
	
	@OneToOne(fetch = FetchType.LAZY,mappedBy="passport")
	private Student student;
	
	
	
	public Passport(String number) {
		this.number = number;
	}
	
	protected Passport() {
		
	}


	public String getNumber() {
		return number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	public Student getStudent() {
		return student;
	}

	public void setStudent(Student student) {
		this.student = student;
	}

	@Override
	public String toString() {
		return "Passport [id=" + id + ", number=" + number + "]";
	}



}
