package com.api.ratelimiter.serviceImpl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.ratelimiter.model.Employee;
import com.api.ratelimiter.repository.EmployeeRepo;
import com.api.ratelimiter.service.EmployeeService;


@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired(required = false)
	EmployeeRepo empRepo;
	
	@Override
	public List<Employee> getEmployees() {
		List<Employee> employees = empRepo.findAll();
		return employees;
	}

	@Override
	public Employee getEmployee(Long empId) {
		Optional<Employee> emp = empRepo.findById(empId);
		return emp.get();
	}

	@Override
	public Employee saveEmployee(Employee emp) {
		Employee e = empRepo.saveAndFlush(emp);
		return e;
	}

	
}
