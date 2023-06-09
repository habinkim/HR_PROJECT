package com.ecoandrich.hr.job.repository;

import com.ecoandrich.hr.payload.job.JobPayloads;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.ecoandrich.hr.domain.department.QDepartment.department;
import static com.ecoandrich.hr.domain.employee.QEmployee.employee;
import static com.ecoandrich.hr.domain.job.QJob.job;
import static com.ecoandrich.hr.domain.job.QJobHistory.jobHistory;

@RequiredArgsConstructor
public class JobHistoryRepositoryCustomImpl implements JobHistoryRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public JPAQuery<JobPayloads.HistoryResponse> fetchQuery(Integer id) {
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
                .orderBy(jobHistory.endDate.desc());
    }

    @Override
    public List<JobPayloads.HistoryResponse> findListByEmployeeId(Integer id) {
        return fetchQuery(id).fetch();
    }

    @Override
    public Page<JobPayloads.HistoryResponse> findPageByEmployeeId(Integer id, Pageable pageable) {
        List<JobPayloads.HistoryResponse> fetch = fetchQuery(id)
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(jobHistory.id.count())
                .from(jobHistory)
                .join(jobHistory.id.employee, employee)
                .join(jobHistory.job, job)
                .join(jobHistory.department, department)
                .where(employee.id.eq(id));

        return PageableExecutionUtils.getPage(fetch, pageable, countQuery::fetchOne);
    }

}
