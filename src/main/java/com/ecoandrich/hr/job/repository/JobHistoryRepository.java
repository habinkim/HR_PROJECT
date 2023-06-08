package com.ecoandrich.hr.job.repository;

import com.ecoandrich.hr.domain.job.JobHistory;
import com.ecoandrich.hr.domain.job.JobHistoryId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobHistoryRepository extends JpaRepository<JobHistory, JobHistoryId>, JobHistoryRepositoryCustom {
}
