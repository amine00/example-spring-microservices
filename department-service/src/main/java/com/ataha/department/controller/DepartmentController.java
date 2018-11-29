package com.ataha.department.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ataha.department.client.EmployeeClient;
import com.ataha.department.model.Department;
import com.ataha.department.repository.DepartmentRepository;

@RestController
public class DepartmentController {

	private static final Logger LOGGER = LoggerFactory.getLogger(DepartmentController.class);

	private final DepartmentRepository departmentRepository;

	private final EmployeeClient employeeClient;

	public DepartmentController(DepartmentRepository departmentRepository, EmployeeClient employeeClient) {
		this.departmentRepository = departmentRepository;
		this.employeeClient = employeeClient;
	}

	@PostMapping("/")
	public Department addDepartment(@RequestBody Department department) {

		LOGGER.info("Department add: {}", department);
		return departmentRepository.add(department);
	}

	@GetMapping("/{id}")
	public Department findDepartmentById(@PathVariable("id") Long id) {

		LOGGER.info("Department find: id={}", id);
		return departmentRepository.findById(id);
	}

	@GetMapping("/")
	public List<Department> findAllDepartments() {

		LOGGER.info("Department find");
		return departmentRepository.findAll();
	}

	@GetMapping("/organization/{organizationId}")
	public List<Department> findDepartmentByOrganizationId(@PathVariable("organizationId") Long organizationId) {

		LOGGER.info("Department find: organizationId={}", organizationId);
		return departmentRepository.findByOrganizationId(organizationId);
	}

	@GetMapping("/organization-with-employees/{organizationId}")
	public List<Department> findByOrganizationWithEmployees(@PathVariable("organizationId") Long organizationId) {

		LOGGER.info("Department find: organizationId={}", organizationId);

		List<Department> departments = departmentRepository.findByOrganizationId(organizationId);

		departments = departments.stream().map(department -> new Department(department.id, department.organizationId,
				department.name, employeeClient.findEmployeesByDepartmentId(department.id)))
				.collect(Collectors.toList());

		return departments;
	}
}
