package com.nauka.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;

import com.nauka.jpa.hibernate.demo.DemoApplication;
import com.nauka.jpa.hibernate.demo.entity.Passport;
import com.nauka.jpa.hibernate.demo.entity.Student;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.transaction.annotation.Transactional;


@SpringBootTest(classes=DemoApplication.class)
class StudentRepositoryTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired 
	StudentRepository studentRepo; // -> Transactional
	
	
	
	@Autowired
	EntityManager em; // -> nie ma włączonych transakcji
	
	
	@Test
	@Transactional // persistence context  
	@DirtiesContext
	
	public void someTest() {
		// operacja bazodanowa 1 -> odzyskaj studenta
		Student student = 	em.find(Student.class,2001L );
		// operacja bazodanowa 2 -> odzyskaj paszport
		Passport passport = student.getPassport();
		// operacja bazodanowa 3 -> uaktualnij studenta  
		student.setName(student.getName() + "-> update");
		// operacja bazodanowa 4 -> uaktualnij paszport
		passport.setNumber("Z1989");

	}
	
	
	@Test
	@Transactional	
	@DirtiesContext
public void retrieveStudentAndPassportDetails() {
		Student student = 	em.find(Student.class,2001L );
			log.info("student -> {}",student);
			log.info("passport -> {}",student.getPassport());
	}

	 

	@Test
	@Transactional
	@DirtiesContext
	public void retrievePassportAndAssociatedStudent() {
		Passport passport = em.find(Passport.class,3002L);
		  log.info("passport -> {}", passport);
		  	log.info("student -> {}",passport.getStudent());
		
	}
	
	
	
	
	
	@Test
	@Transactional
	public void retrieveStudentAndCourses() {
		Student student = em.find(Student.class,2001L);
		log.info("szukany student -> {}",student);
		log.info("szukane kursy -> {}",student.getCourses());
		
	}
	

}
