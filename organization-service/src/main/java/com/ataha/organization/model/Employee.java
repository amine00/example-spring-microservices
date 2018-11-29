package com.ataha.organization.model;

public class Employee {

	public final Long id;
	public final String name;
	public final int age;
	public final String position;

	public Employee(Long id, String name, int age, String position) {
		this.id = id;
		this.name = name;
		this.age = age;
		this.position = position;
	}
	
}
