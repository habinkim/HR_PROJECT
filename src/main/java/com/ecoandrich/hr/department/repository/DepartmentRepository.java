package com.ecoandrich.hr.department.repository;

import com.ecoandrich.hr.domain.department.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Integer>, DepartmentRepositoryCustom {

}
