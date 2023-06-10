package com.ecoandrich.hr.job.service;

import com.ecoandrich.hr.domain.job.Job;
import com.ecoandrich.hr.employee.service.EmployeeService;
import com.ecoandrich.hr.job.repository.JobHistoryRepository;
import com.ecoandrich.hr.job.repository.JobRepository;
import com.ecoandrich.hr.payload.job.JobPayloads;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class JobService {

    private final JobRepository jobRepository;
    private final JobHistoryRepository jobHistoryRepository;

    private final EntityManager em;

    private final EmployeeService employeeService;

    @Transactional(readOnly = true)
    public List<JobPayloads.HistoryResponse> history(Integer id) {
        employeeService.findById(id);
        return jobHistoryRepository.findListByEmployeeId(id);
    }

    @Transactional(readOnly = true)
    public Page<JobPayloads.HistoryResponse> historyWithPaging(Integer id, Pageable pageable) {
        employeeService.findById(id);
        return jobHistoryRepository.findPageByEmployeeId(id, pageable);
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void updateSalary(List<String> jobIds, BigDecimal increaseRate) {
        jobRepository.updateSalary(jobIds, increaseRate);
        em.clear();
        em.flush();
    }
}
