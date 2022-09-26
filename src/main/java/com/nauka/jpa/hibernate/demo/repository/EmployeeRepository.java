package com.nauka.jpa.hibernate.demo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import com.nauka.jpa.hibernate.demo.entity.Employee;
import com.nauka.jpa.hibernate.demo.entity.FullTimeEmployee;
import com.nauka.jpa.hibernate.demo.entity.PartTimeEmployee;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
@Transactional
public class EmployeeRepository {
	
	@Autowired
	EntityManager em;

	
//insert employee
//retrieve all employees	
	
	public void insertEmployee(Employee employee) {
		em.persist(employee);
	}
	
//	public List<Employee>allEmployees(){
//		
//	List<Employee> employees =  em.createQuery("select e from Employee e", Employee.class).getResultList();
//	return employees;
//	
//	}
	
	
	public List<PartTimeEmployee>allPartTimeEmployees(){
		
		List<PartTimeEmployee> employees =  em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
		return employees;
	}
	
	
	public List<FullTimeEmployee>fullTimeEmployees(){
		
		List<FullTimeEmployee> employees =  em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
		return employees;
	}
	
	
	
	
}
