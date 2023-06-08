package com.ecoandrich.hr.job.repository;

import com.ecoandrich.hr.payload.job.JobPayloads;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static com.ecoandrich.hr.domain.employee.QDepartment.department;
import static com.ecoandrich.hr.domain.employee.QEmployee.employee;
import static com.ecoandrich.hr.domain.job.QJob.job;
import static com.ecoandrich.hr.domain.job.QJobHistory.jobHistory;

@RequiredArgsConstructor
public class JobHistoryRepositoryCustomImpl implements JobHistoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    @Override
    public List<JobPayloads.HistoryResponse> findListByEmployeeId(Integer id) {

        return queryFactory.select(Projections.fields(JobPayloads.HistoryResponse.class,
                        employee.id.as("employeeId"),
                        employee.firstName,
                        employee.lastName,
                        jobHistory.id.startDate,
                        jobHistory.endDate,
                        job.jobId,
                        job.jobTitle,
                        department.id.as("departmentId"),
                        department.departmentName
                ))
                .from(jobHistory)
                .join(jobHistory.id.employee, employee)
                .join(jobHistory.job, job)
                .join(jobHistory.department, department)
                .where(employee.id.eq(id))
                .fetch();
    }
}
