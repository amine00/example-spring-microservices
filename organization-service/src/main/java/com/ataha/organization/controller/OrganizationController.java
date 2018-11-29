package com.ataha.organization.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.ataha.organization.client.DepartmentClient;
import com.ataha.organization.client.EmployeeClient;
import com.ataha.organization.model.Department;
import com.ataha.organization.model.Employee;
import com.ataha.organization.model.Organization;
import com.ataha.organization.repository.OrganizationRepository;

@RestController
public class OrganizationController {

	private static final Logger LOGGER = LoggerFactory.getLogger(OrganizationController.class);

	private final OrganizationRepository organizationRepository;

	private final DepartmentClient departmentClient;

	private final EmployeeClient employeeClient;

	public OrganizationController(OrganizationRepository organizationRepository, DepartmentClient departmentClient,
			EmployeeClient employeeClient) {
		this.organizationRepository = organizationRepository;
		this.departmentClient = departmentClient;
		this.employeeClient = employeeClient;
	}

	@PostMapping
	public Organization addOrganization(@RequestBody Organization organization) {

		LOGGER.info("Organization add: {}", organization);
		return organizationRepository.add(organization);
	}

	@GetMapping
	public List<Organization> findAllOrganizations() {

		LOGGER.info("Organization find");
		return organizationRepository.findAll();
	}

	@GetMapping("/{id}")
	public Organization findOrganizationById(@PathVariable("id") Long id) {

		LOGGER.info("Organization find: id={}", id);
		return organizationRepository.findById(id);
	}

	@GetMapping("/organization-with-departments/{id}")
	public Organization findOrganizationByIdWithDepartments(@PathVariable("id") Long id) {

		LOGGER.info("Organization find: id={}", id);

		Organization organization = organizationRepository.findById(id);

		List<Department> departments = departmentClient.findDepartmentsByOrganizationId(organization.id);

		return new Organization(organization.id, organization.name, organization.address, departments, null);
	}

	@GetMapping("/organization-with-departments-and-employees/{id}")
	public Organization findByIdWithDepartmentsAndEmployees(@PathVariable("id") Long id) {

		LOGGER.info("Organization find: id={}", id);
		Organization organization = organizationRepository.findById(id);

		List<Department> departments = departmentClient.findDepartmentsByOrganizationIdWithEmployees(organization.id);

		List<Employee> employees = departments.stream().flatMap(department -> department.employees.stream())
				.collect(Collectors.toList());

		return new Organization(organization.id, organization.name, organization.address, departments, employees);
	}

	@GetMapping("/organization-with-employees/{id}")
	public Organization findOrganizationByIdWithEmployees(@PathVariable("id") Long id) {

		LOGGER.info("Organization find: id={}", id);

		Organization organization = organizationRepository.findById(id);

		List<Employee> employees = employeeClient.findEmployeesByOrganizationId(organization.id);

		return new Organization(organization.id, organization.name, organization.address, null, employees);
	}

}
