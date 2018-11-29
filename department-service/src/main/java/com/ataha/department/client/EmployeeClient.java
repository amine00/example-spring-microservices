package com.ataha.department.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ataha.department.model.Employee;

@FeignClient(name = "employee-service")
public interface EmployeeClient {

	@GetMapping("/employee/department/{departmentId}")
	List<Employee> findEmployeesByDepartmentId(@PathVariable("departmentId") Long departmentId);
}
