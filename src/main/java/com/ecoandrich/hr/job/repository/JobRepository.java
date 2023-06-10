package com.ecoandrich.hr.job.repository;

import com.ecoandrich.hr.domain.job.Job;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JobRepository extends JpaRepository<Job, String>, JobRepositoryCustom {
}
