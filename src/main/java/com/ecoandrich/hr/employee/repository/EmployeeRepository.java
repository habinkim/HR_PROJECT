package com.ecoandrich.hr.employee.repository;

import com.ecoandrich.hr.domain.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
}
