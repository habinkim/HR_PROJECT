package com.ecoandrich.hr.job.service;

import com.ecoandrich.hr.employee.service.EmployeeService;
import com.ecoandrich.hr.job.repository.JobHistoryRepository;
import com.ecoandrich.hr.payload.job.JobPayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class JobService {

    private final JobHistoryRepository repository;
    private final EmployeeService employeeService;

    @Transactional(readOnly = true)
    public List<JobPayloads.HistoryResponse> history(Integer id) {
        employeeService.findById(id);
        return repository.findListByEmployeeId(id);
    }

    @Transactional(readOnly = true)
    public Page<JobPayloads.HistoryResponse> historyWithPaging(Integer id, Pageable pageable) {
        employeeService.findById(id);
        return repository.findPageByEmployeeId(id, pageable);
    }
}
