package com.ataha.employee.model;

public class Employee {

	public final Long id;
	public final Long organizationId;
	public final Long departmentId;
	public final String name;
	public final int age;
	public final String position;

	public Employee(Long id, Long organizationId, Long departmentId, String name, int age, String position) {
		this.id = id;
		this.organizationId = organizationId;
		this.departmentId = departmentId;
		this.name = name;
		this.age = age;
		this.position = position;
	}

}
