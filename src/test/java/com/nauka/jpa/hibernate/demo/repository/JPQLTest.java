package com.nauka.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import com.nauka.jpa.hibernate.demo.DemoApplication;
import com.nauka.jpa.hibernate.demo.entity.Course;
import com.nauka.jpa.hibernate.demo.entity.Student;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes=DemoApplication.class)
class JPQLTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	@Autowired
	EntityManager em;
	
	@Test
	public void jpqlMojTest(){
	List courseList = em.createQuery("select c from Course c").getResultList();
	log.info("moj wlasny select c from course c ->{}",courseList);
	}
	

	@Test
	public void jpqlMojTest2() {
		
		TypedQuery<Course>courseList = em.createQuery("select c from Course c",Course.class);
		log.info("moj wlasny select ->{}",courseList);		
	}
	
	@Test
	public void jpqlTyped() {
		
		TypedQuery<Course> typedQuery =	
				em.createNamedQuery("query_get_all_courses", Course.class);
		List<Course>resultList =typedQuery.getResultList();
		log.info("Select c from Course c ->{}",resultList);		
	}
	
	

	
	
	@Test
	public void native_queries_test() {	
	//	Query query = em.createNativeQuery("SELECT * FROM COURSE where id=?", Course.class);
		//	query.setParameter(1, 1001);

		Query query = em.createNativeQuery("SELECT * FROM COURSE where id=:id", Course.class);
		query.setParameter("id", 1001);
		
		List resultList = query.getResultList();
		log.info("Native query  select * from course where ->{}",resultList);
	}
	
	
	@Test
	@Transactional
	public void native_queries_update_all_test() {
		Query query = em.createNativeQuery("UPDATE COURSE SET last_updated_date=CURRENT_TIMESTAMP()");
		int allRowsUpdate = query.executeUpdate();
		log.info("Liczba updatowanych rzędów -> {}",allRowsUpdate);
		
		
	}
	
	@Test
	public void queryStudentWithoutCourse() {
		
		TypedQuery<Course>resulQuery =  em.createQuery("Select c From Course c where c.students is empty",Course.class);
		List<Course>resultList = resulQuery.getResultList();
		log.info("lista kursow bez studentow ->{}",resultList);
	}
	
	
	@Test
	public void queryStudentLikePattern() {
		
		TypedQuery<Student>resulQuery =  em.createQuery("Select s From Student s where s.passport.number like '%1234%'",Student.class);
		List<Student>resultList = resulQuery.getResultList();
		log.info("lista Studentow z wyszukiwanym paszportem ->{}",resultList);
		
	}
	

	
	
}
