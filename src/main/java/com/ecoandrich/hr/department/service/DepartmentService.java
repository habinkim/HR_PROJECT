package com.ecoandrich.hr.department.service;

import com.ecoandrich.hr.common.response.MessageCode;
import com.ecoandrich.hr.department.repository.DepartmentRepository;
import com.ecoandrich.hr.domain.department.Department;
import com.ecoandrich.hr.employee.service.EmployeeService;
import com.ecoandrich.hr.exception.CommonApplicationException;
import com.ecoandrich.hr.job.service.JobService;
import com.ecoandrich.hr.payload.department.DepartmentPayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;
    private final EmployeeService employeeService;
    private final JobService jobService;

    @Transactional(readOnly = true)
    public List<DepartmentPayloads.InfoResponse> findAllV1() {
        return repository.findAllV1();
    }

    @Transactional(readOnly = true)
    public Page<DepartmentPayloads.InfoResponse> findAllV2(Pageable pageable) {
        return repository.findAllV2(pageable);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ, readOnly = true)
    public Page<DepartmentPayloads.InfoResponse> findAllV3(DepartmentPayloads.InfoRequest request) {
        return repository.findAllV3(request);
    }

    @Transactional()
    public void updateSalary(DepartmentPayloads.SalaryRequest request) {
        findById(request.departmentId());
        employeeService.updateSalary(request.departmentId(), request.increaseRate());
        List<String> jobIds = employeeService.findJobIdByDepartmentId(request.departmentId());
        jobService.updateSalary(jobIds, request.increaseRate());

    }

    @Transactional(readOnly = true)
    public Department findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new CommonApplicationException(MessageCode.NOT_FOUND_DEPARTMENT));
    }
}
