package com.nauka.jpa.hibernate.demo.entity;



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;


@Entity
public class Review extends Object {
	
	@Id
	@GeneratedValue
	private long id;
	
	@Column
	private String rating;
	
	@Column(nullable=false)
	private String description;
	
	@ManyToOne
	private Course course;
	
	
	public Review(String rating,String description) {
		super();
		this.description = description;
		this.rating = rating;
	}
	
	protected Review() {
		
	}

	
	

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return String.format("Review [%s %s]",description,rating);
	}

	public String getRating() {
		return rating;
		
	}

	public void setRating(String rating) {
		this.rating = rating;
		
	}

	public Course getCourse() {
		return course;
	}

	public void setCourse(Course course) {
		this.course = course;
	}
	
	



	



}
