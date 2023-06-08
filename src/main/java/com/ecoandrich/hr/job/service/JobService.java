package com.ecoandrich.hr.job.service;

import com.ecoandrich.hr.job.repository.JobHistoryRepository;
import com.ecoandrich.hr.payload.job.JobPayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class JobService {

    private final JobHistoryRepository repository;

    @Transactional(readOnly = true)
    public List<JobPayloads.HistoryResponse> history(Integer id) {
        return repository.findListByEmployeeId(id);
    }
}
