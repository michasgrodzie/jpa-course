package com.nauka.jpa.hibernate.demo;

import java.math.BigDecimal;

import com.nauka.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.nauka.jpa.hibernate.demo.entity.PartTimeEmployee;
import com.nauka.jpa.hibernate.demo.repository.CourseRepository;
import com.nauka.jpa.hibernate.demo.repository.EmployeeRepository;
import com.nauka.jpa.hibernate.demo.repository.StudentRepository;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	CourseRepository repo;
	
	@Autowired
	StudentRepository studentRepo;
	
	@Autowired 
	EmployeeRepository employeeRepo;
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		
		//repo.playWithEntityManager();
		
		
//		studentRepo.saveStudentWithPassport();
//		repo.addHardCodedReviewsToCourse(1003);
//		
//		List <Review> reviews = new ArrayList<>();
//		reviews.add( new Review("3","Bylo ok"));
//		reviews.add( new Review("3","Mozna ale nie trzeba"));
//		reviews.add( new Review("3","Troche trudne"));
//		reviews.add( new Review("2","Bylo slabo"));
//		
//		repo.addReviewsToCourse(1002L, reviews);
//		
//		studentRepo.insertHardCodedStudentAndCourse();
		
		

		employeeRepo.insertEmployee(new FullTimeEmployee("Kasia Zilinska",new BigDecimal(5000)));
		
		
		
		employeeRepo.insertEmployee( new PartTimeEmployee("Michal Zilinski", new BigDecimal(4000)));
		
//		logger.info("wszyscy pracownicy -> {}",employeeRepo.allEmployees());
		logger.info("part time employees ->{}",employeeRepo.allPartTimeEmployees());
		logger.info("full time employees ->{}",employeeRepo.fullTimeEmployees());
		
		
		
		
		
		
		
		
		
	
		
		
		
		
	}

}
