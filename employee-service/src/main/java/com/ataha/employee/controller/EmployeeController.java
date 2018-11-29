package com.ataha.employee.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ataha.employee.model.Employee;
import com.ataha.employee.repository.EmployeeRepository;

@RestController
public class EmployeeController {

	private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

	private final EmployeeRepository employeeRepository;

	public EmployeeController(final EmployeeRepository employeeRepository) {
		this.employeeRepository = employeeRepository;
	}

	@PostMapping("/")
	public Employee addEmployee(@RequestBody Employee employee) {

		LOGGER.info("Employee add: {}", employee);
		return employeeRepository.add(employee);
	}

	@GetMapping("/{id}")
	public Employee findEmployeeById(@PathVariable("id") Long id) {

		LOGGER.info("Employee find: id={}", id);
		return employeeRepository.findById(id);
	}

	@GetMapping("/")
	public List<Employee> findAllEmployees() {

		LOGGER.info("Employee find");
		return employeeRepository.findAll();
	}

	@GetMapping("/department/{departmentId}")
	public List<Employee> findEmployeesByDepartment(@PathVariable("departmentId") Long departmentId) {

		LOGGER.info("Employee find: departmentId={}", departmentId);
		return employeeRepository.findByDepartmentId(departmentId);
	}

	@GetMapping("/organization/{organizationId}")
	public List<Employee> findEmployeesByOrganization(@PathVariable("organizationId") Long organizationId) {

		LOGGER.info("Employee find: organizationId={}", organizationId);
		return employeeRepository.findByOrganizationId(organizationId);
	}
}
