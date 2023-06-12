package com.ecoandrich.hr.employee.repository;

import com.ecoandrich.hr.domain.employee.Employee;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface EmployeeRepository extends JpaRepository<Employee, Integer>, EmployeeRepositoryCustom {

    @Override
    @EntityGraph(attributePaths = {"job", "manager", "department"})
    List<Employee> findAll();

    @Override
    @EntityGraph(attributePaths = {"job", "manager", "department"})
    Optional<Employee> findById(Integer id);

    @EntityGraph(attributePaths = "department")
    List<Employee> findByDepartmentId(Integer departmentId);
}
