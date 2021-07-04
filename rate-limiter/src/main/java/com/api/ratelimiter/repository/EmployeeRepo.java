/**
 * 
 */
package com.api.ratelimiter.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.api.ratelimiter.model.Employee;

/**
 * @author vikas
 *
 */

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long> {

}
