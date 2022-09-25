package com.nauka.jpa.hibernate.demo.entity;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@NamedQueries(value= {
		@NamedQuery(name="query_get_all_courses",query="Select c From Course c"),
		@NamedQuery(name="get_query_gabrynia",query="Select c From Course c where name like 'Gabrynia'")
})


public class Course extends Object {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column(nullable=false)
	private String name;
	
	
	@OneToMany(mappedBy="course")
	private List<Review>reviews = new ArrayList<>();
	
	@UpdateTimestamp
	private LocalDateTime lastUpdatedDate;

	@CreationTimestamp
	private LocalDateTime createdDate;
	
	@ManyToMany(mappedBy = "courses")
	private List<Student>students = new ArrayList<>();
	
	
	
	
	public Course(String name) {
		this.name = name;
	}
	
	protected Course() {
		
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	
	
	public List<Review> getReviews() {
		return reviews;
	}

	public void addRatings(Review review) {
		this.reviews.add(review);
	}
	
	public void removeRating(Review review) {
		
	}
	
	

	public List<Student> getStudents() {
		return students;
	}

	public void addStudents(Student student) {
		this.students.add(student);
	}

	@Override
	public String toString() {
		return "Course [id=" + id + ", name=" + name + "]";
	}



}
