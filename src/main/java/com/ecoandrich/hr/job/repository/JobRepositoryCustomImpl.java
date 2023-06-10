package com.ecoandrich.hr.job.repository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;

import java.math.BigDecimal;
import java.util.List;

import static com.ecoandrich.hr.domain.job.QJob.job;

@RequiredArgsConstructor
public class JobRepositoryCustomImpl implements JobRepositoryCustom {

    private final JPAQueryFactory queryFactory;


    @Override
    public void updateSalary(List<String> jobIds, BigDecimal increaseRate) {
        queryFactory.update(job)
                .set(job.minSalary, job.minSalary.add(job.minSalary.multiply(increaseRate).divide(100)))
                .set(job.maxSalary, job.maxSalary.add(job.maxSalary.multiply(increaseRate).divide(100)))
                .where(job.jobId.in(jobIds))
                .execute();
    }
}
