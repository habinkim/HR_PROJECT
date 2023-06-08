package com.ecoandrich.hr.employee.service;

import com.ecoandrich.hr.common.response.MessageCode;
import com.ecoandrich.hr.domain.employee.Employee;
import com.ecoandrich.hr.employee.repository.EmployeeRepository;
import com.ecoandrich.hr.exception.CommonApplicationException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    @Transactional(readOnly = true)
    public Employee findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new CommonApplicationException(MessageCode.NOT_FOUND_EMPLOYEE));
    }

}
