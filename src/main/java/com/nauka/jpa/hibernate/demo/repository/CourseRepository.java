package com.nauka.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.nauka.jpa.hibernate.demo.entity.Course;
import com.nauka.jpa.hibernate.demo.entity.Review;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class CourseRepository {
	
	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;

	
	public Course findById(long id) {
		return em.find(Course.class, id);
	}
	
	public void deleteById(long id) {
		Course course = findById(id);
		em.remove(course);
	
	}
	
	
	public Course save(Course course) {
		 if(course.equals(null)) {
			 em.persist(course);
		 }else {
			 em.merge(course);
		 }
		 return course;
	}
	
	public void playWithEntityManager() {
		log.info("Eksperymenty EntityManagera");
		
		Course course = new Course("Pętki Gabryni");
		em.persist(course);
	Course course2 = findById(1001);
	course2.setName("Upatowanie czasu");
	
		
	}

	
	public void addHardCodedReviewsToCourse(int courseNo) {
		Course course = findById((long)courseNo);
			log.info("lista opinii przed updatem ---> {}",course.getReviews());
				Review review = new Review("0","Bardzo slaby");
				Review review2 = new Review("5","Wyjatkowo dobry");
				
				course.addRatings(review);
				review.setCourse(course);
				
				course.addRatings(review2);
				review2.setCourse(course);	
					
				
				log.info("lista opinii po updacie --->{}",course.getReviews());
				
				em.persist(review2);
				em.persist(review);	
		
	}
	
	public void addReviewsToCourse(Long courseid, List<Review>reviews) {
		
		Course course = findById(courseid);			
				for(Review review:reviews) {
			course.addRatings(review);
			review.setCourse(course);			
				em.persist(review);
				}
		
		
		
	}
	
	
	
	
	
	
}
