package com.ecoandrich.hr.employee.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import static com.ecoandrich.hr.domain.department.QDepartment.department;
import static com.ecoandrich.hr.domain.employee.QEmployee.employee;
import static com.ecoandrich.hr.domain.job.QJob.job;

@RequiredArgsConstructor
public class EmployeeRepositoryCustomImpl implements EmployeeRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    @Override
    public void updateSalary(Integer departmentId, BigDecimal increaseRate) {
        queryFactory.update(employee)
                .set(employee.salary, employee.salary.add(employee.salary.multiply(increaseRate).divide(100)))
                .where(employee.department.id.eq(departmentId))
                .execute();
    }

    @Override
    public List<String> findJobIdByDepartmentId(Integer departmentId) {
        return queryFactory.select(job.jobId)
                .distinct()
                .from(employee)
                .join(employee.department, department)
                .join(employee.job, job)
                .where(department.id.eq(departmentId))
                .fetch();
    }
}
