package com.ataha.organization.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Organization {

	public final Long id;
	public final String name;
	public final String address;
	public final List<Department> departments;
	public final List<Employee> employees;
	
	public Organization(Long id, String name, String address, List<Department> departments, List<Employee> employees) {
		this.id = id;
		this.name = name;
		this.address = address;
		this.departments = Collections.unmodifiableList(new ArrayList<>(departments));
		this.employees = Collections.unmodifiableList(new ArrayList<>(employees));
	}

}
