package com.ataha.department.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Department {

	public final Long id;
	public final Long organizationId;
	public final String name;
	public final List<Employee> employees;
	
	public Department(final Long id, final Long organizationId, final String name, final List<Employee> employees) {
		this.id = id;
		this.organizationId = organizationId;
		this.name = name;
		this.employees = (employees != null ? Collections.unmodifiableList(new ArrayList<>(employees)) : null);
	}

}
