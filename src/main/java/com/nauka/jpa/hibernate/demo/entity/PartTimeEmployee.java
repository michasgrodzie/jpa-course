package com.nauka.jpa.hibernate.demo.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;

@Entity
public class PartTimeEmployee extends Employee {
	
	private BigDecimal hourlyWage;


protected PartTimeEmployee() {
	
}
	
public PartTimeEmployee(String name, BigDecimal hourlyWage) {
	super(name);
	this.setHourlyWage(hourlyWage);
	
	
}

public BigDecimal getHourlyWage() {
	return hourlyWage;
	
}

public void setHourlyWage(BigDecimal hourlyWage) {
	this.hourlyWage = hourlyWage;
	
}

@Override
public String getName() {
	// TODO Auto-generated method stub
	return super.getName();
}

@Override
public long getId() {
	// TODO Auto-generated method stub
	return super.getId();
}

@Override
public String toString() {
	// TODO Auto-generated method stub
	return super.toString();
}
	

}
