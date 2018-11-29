package com.ataha.organization.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {

	public final Long id;
	public final String name;
	public final List<Employee> employees;
	
	public Department(final Long id, final String name, final List<Employee> employees) {
		this.id = id;
		this.name = name;
		this.employees = Collections.unmodifiableList(new ArrayList<>(employees));
	}

}
