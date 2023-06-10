package com.ecoandrich.hr.employee.repository;

import java.math.BigDecimal;
import java.util.List;

public interface EmployeeRepositoryCustom {
    void updateSalary(Integer departmentId, BigDecimal increaseRate);

    List<String> findJobIdByDepartmentId(Integer departmentId);
}
