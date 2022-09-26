package com.nauka.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.nauka.jpa.hibernate.demo.DemoApplication;
import com.nauka.jpa.hibernate.demo.entity.Course;

import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest(classes=DemoApplication.class)
class CriteriaQueryTest {

	private Logger log = LoggerFactory.getLogger(this.getClass());
	
	
	
	@Autowired
	EntityManager em;


	
	@Test
	public void jpqlTyped_with_criteriaBuilder() {
		CriteriaBuilder cb =	em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course>courseRoot = cq.from(Course.class);
		TypedQuery<Course> typedQuery =	em.createQuery(cq.select(courseRoot));
		List<Course>resultList =typedQuery.getResultList();
		log.info("Select c from Course c ->{}",resultList);		
	}
	

	@Test
	public void like_query_with_criteria() {
		CriteriaBuilder cb =	em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course>courseRoot = cq.from(Course.class);
		Predicate like =	cb.like(courseRoot.get("name"),"%ie");
		cq.where(like);
		TypedQuery<Course> typedQuery =	em.createQuery(cq.select(courseRoot));
		List<Course>resultList =typedQuery.getResultList();
		log.info("like query with criteria ->{}",resultList);			
	}
	
	
	@Test
	public void criteria_courses_without_students() {
		CriteriaBuilder cb =	em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course>courseRoot = cq.from(Course.class);		
		Predicate predicate = cb.isEmpty(courseRoot.get("students"));
		cq.where(predicate);
		TypedQuery<Course> typedQuery =	em.createQuery(cq.select(courseRoot));
		List<Course>resultList =typedQuery.getResultList();
		log.info("criteriaQ Course without Students ->{}",resultList);			
	}
	
	@Test
	public void criteria_with_join() {
		CriteriaBuilder cb =	em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course>courseRoot = cq.from(Course.class);	
		

		Join<Object, Object>join = courseRoot.join("students");
		
		TypedQuery<Course> typedQuery =	em.createQuery(cq.select(courseRoot));
		List<Course>resultList =typedQuery.getResultList();
		log.info("Typed query with join  ->{}",resultList);	
		
		
	}
	@Test
	public void criteria_with_join_left() {
		CriteriaBuilder cb =	em.getCriteriaBuilder();
		CriteriaQuery<Course> cq = cb.createQuery(Course.class);
		Root<Course>courseRoot = cq.from(Course.class);	
		
		
		Join<Object, Object>join = courseRoot.join("students",JoinType.LEFT);
		
		TypedQuery<Course> typedQuery =	em.createQuery(cq.select(courseRoot));
		List<Course>resultList =typedQuery.getResultList();
		log.info("Typed query join left ->{}",resultList);	
		
		
	}
	
	
}
