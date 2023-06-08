package com.ecoandrich.hr.job.repository;

import com.ecoandrich.hr.payload.job.JobPayloads;

import java.util.List;

public interface JobHistoryRepositoryCustom {

    List<JobPayloads.HistoryResponse> findListByEmployeeId(Integer id);

}
