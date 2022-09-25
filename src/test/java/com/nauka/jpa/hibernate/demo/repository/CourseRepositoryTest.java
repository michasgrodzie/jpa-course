package com.nauka.jpa.hibernate.demo.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import javax.persistence.EntityManager;

import com.nauka.jpa.hibernate.demo.DemoApplication;
import com.nauka.jpa.hibernate.demo.entity.Course;
import com.nauka.jpa.hibernate.demo.entity.Review;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(classes=DemoApplication.class)
class CourseRepositoryTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	CourseRepository courseRepo;
	
	@Autowired
	EntityManager em;
	
	@Test
public void findById() {
	log.info("Trwa testowanie");
	Course findById = courseRepo.findById(1001);
	assertEquals("Programowanie",findById.getName());
	}
	
//	@Test
//	@DirtiesContext
//	public void deleteById_basic() {
//	courseRepo.deleteById(1002);
//	assertNull(courseRepo.findById(1002));
//	}
	 
	@Test
	@DirtiesContext
	public void save_basic() {
		Course course = courseRepo.findById(1001);
		assertEquals("Programowanie",course.getName());
		course.setName("Michal Zielinski");
		courseRepo.save(course);
		
		Course course1 = courseRepo.findById(1001);
		assertEquals("Michal Zielinski",course1.getName());
		
	}

	@Test
	@DirtiesContext
	public void playWithEntityManager() {
		courseRepo.playWithEntityManager();
		
	}
	
	@Test
	@Transactional
	public void retrieveReviewsForCourse() {
		Course course = courseRepo.findById(1001);
		log.info("->{}",course.getReviews());
		
	}

	@Test
	@Transactional
	public void retrievieCourseForReview() {
	Review review = em.find(Review.class,4001L);
	log.info("kurs dla review {} -> {}",review,review.getCourse());
		
	}
	
	

	
	
	
	

}
