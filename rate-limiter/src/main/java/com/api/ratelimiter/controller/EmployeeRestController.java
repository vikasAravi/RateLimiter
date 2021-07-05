/**
 * 
 */
package com.api.ratelimiter.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.ratelimiter.model.Employee;
import com.api.ratelimiter.response.ResponseWrapperClass;
import com.api.ratelimiter.service.EmployeeService;

/**
 * @author vikas
 *
 */

@RestController
public class EmployeeRestController {

	private final static int LIMIT = 5; // change the limit accordingly
	private final static String ERROR_CODE = "900";
	private final static String ERROR_DESCRIPTION = "LIMIT EXCEEDED";

	@Autowired(required = false)
	private EmployeeService empService;

	@Autowired(required = false)
	SchedulerClass scheduler;

	/**
	 * @return all the employees
	 */
	@GetMapping("/getEmployees")
	public ResponseWrapperClass<Employee> getEmployees() {
		ResponseWrapperClass<Employee> response = new ResponseWrapperClass<>();
		List<Employee> employees = empService.getEmployees();
		response.setCollectionData(employees);
		return response;
	}

	/**
	 * @param apiId( unique key from the request )
	 * @param empId
	 * @return employee with empId
	 */
	@GetMapping("{apiId}/getEmployee/{empId}")
	public ResponseWrapperClass<Employee> getEmployee(@PathVariable("apiId") String apiId,
			@PathVariable(name = "empId") Long empId) {
		// consider this endpoint as tenant
		Map<String, Integer> requestMap = scheduler.getRequestMap();
		ResponseWrapperClass<Employee> response = new ResponseWrapperClass<>();
		scheduler.addRequestToMap(apiId);
		if (requestMap.get(apiId) > (LIMIT)) {
			response.setErrorCode(ERROR_CODE);
			response.setErrorDescription(ERROR_DESCRIPTION);
			return response;
		}
		Employee employee = empService.getEmployee(empId);
		response.setData(employee);
		return response;
	}

	/**
	 * 
	 * @param emp
	 * @return emp
	 */
	@PostMapping("/saveEmployee")
	public Employee saveEmployee(Employee emp) {
		empService.saveEmployee(emp);
		return emp;
	}

}
