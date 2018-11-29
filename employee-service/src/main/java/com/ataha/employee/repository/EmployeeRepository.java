package com.ataha.employee.repository;

import static java.util.stream.Collectors.toList;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.ataha.employee.model.Employee;

public class EmployeeRepository {

	private List<Employee> employees = new ArrayList<>();

	public Employee add(Employee employee) {

		employees.add(employee);
		return employee;
	}

	public Employee findById(Long id) {

		Optional<Employee> OptionalEmployee = employees.stream().filter(employee -> employee.id.equals(id)).findFirst();

		if (OptionalEmployee.isPresent()) {
			return OptionalEmployee.get();
		} else {
			return null;
		}
	}

	public List<Employee> findAll() {

		return employees;
	}

	public List<Employee> findByDepartmentId(Long departmentId) {

		return employees.stream().filter(employee -> employee.departmentId.equals(departmentId)).collect(toList());
	}

	public List<Employee> findByOrganizationId(Long organizationId) {

		return employees.stream().filter(employee -> employee.organizationId.equals(organizationId)).collect(toList());
	}
}
