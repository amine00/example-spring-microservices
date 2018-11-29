package com.ataha.department.repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import com.ataha.department.model.Department;

public class DepartmentRepository {

	private List<Department> departments = new ArrayList<>();

	public Department add(Department department) {

		departments.add(department);
		return department;
	}

	public Department findById(Long id) {

		Optional<Department> optionalDepartment = departments.stream().filter(department -> department.id.equals(id)).findFirst();

		if (optionalDepartment.isPresent()) {
			return optionalDepartment.get();
		} else {
			return null;
		}
	}

	public List<Department> findAll() {
		
		return departments;
	}

	public List<Department> findByOrganizationId(Long organizationId) {
		
		return departments.stream().filter(a -> a.organizationId.equals(organizationId)).collect(Collectors.toList());
	}

}
