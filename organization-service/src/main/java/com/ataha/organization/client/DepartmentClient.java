package com.ataha.organization.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ataha.organization.model.Department;

@FeignClient(name = "department-service")
public interface DepartmentClient {

	@GetMapping("/organization/{organizationId}")
	public List<Department> findDepartmentsByOrganizationId(@PathVariable("organizationId") Long organizationId);

	@GetMapping("/organization-with-employees/{organizationId}")
	public List<Department> findDepartmentsByOrganizationIdWithEmployees(@PathVariable("organizationId") Long organizationId);
}
