package com.ecoandrich.hr.job.repository;

import com.ecoandrich.hr.payload.job.JobPayloads;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface JobHistoryRepositoryCustom {

    List<JobPayloads.HistoryResponse> findListByEmployeeId(Integer id);

    Page<JobPayloads.HistoryResponse> findPageByEmployeeId(Integer id, Pageable pageable);

}
