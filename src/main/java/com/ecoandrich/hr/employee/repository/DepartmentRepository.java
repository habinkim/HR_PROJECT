package com.ecoandrich.hr.employee.repository;

import com.ecoandrich.hr.domain.employee.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer> {
}
