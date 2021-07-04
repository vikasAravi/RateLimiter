/**
 * 
 */
package com.api.ratelimiter.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.api.ratelimiter.model.Employee;

/**
 * @author vikas
 *
 */
@Service
public interface EmployeeService {
	
	public List<Employee> getEmployees();
	
	public Employee getEmployee(Long empId);
	
	public Employee saveEmployee(Employee emp);
}
