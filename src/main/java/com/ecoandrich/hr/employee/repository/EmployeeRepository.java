package com.ecoandrich.hr.employee.repository;

import com.ecoandrich.hr.domain.employee.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    @Override
    @EntityGraph(attributePaths = {"job", "manager", "department"})
    Optional<Employee> findById(Integer id);
}
