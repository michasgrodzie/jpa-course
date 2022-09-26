package com.nauka.jpa.hibernate.demo.repository;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.nauka.jpa.hibernate.demo.entity.Course;
import com.nauka.jpa.hibernate.demo.entity.Passport;
import com.nauka.jpa.hibernate.demo.entity.Student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class StudentRepository {
	
	@Autowired
	EntityManager em;

	
	public Student findById(long id) {
		return em.find(Student.class, id);
	}
	
	public void deleteById(long id) {
		Student student = findById(id);
		em.remove(student);
	
	}
	
	
	public Student save(Student student) {
		 if(student.equals(null)) {
			 em.persist(student);
		 }else {
			 em.merge(student);
		 }
		 return student;
	}
	
	public void saveStudentWithPassport() {
			
		Passport passport = new Passport("Z1983");
		em.persist(passport);
		Student student = new Student("EM Student Mike");
		student.setPassport(passport);
		em.persist(student);
		
	}
	

public void insertHardCodedStudentAndCourse() {
	
	Student student = new Student("Ania");
	Course course = new Course("Nic");
	em.persist(student);
	em.persist(course);
	student.addCourses(course);
	course.addStudents(student);
	em.persist(student);
	
}
	
	
	
	
	
}
