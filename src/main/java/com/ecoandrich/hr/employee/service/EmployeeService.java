package com.ecoandrich.hr.employee.service;

import com.ecoandrich.hr.common.response.MessageCode;
import com.ecoandrich.hr.domain.employee.Employee;
import com.ecoandrich.hr.employee.repository.EmployeeRepository;
import com.ecoandrich.hr.exception.CommonApplicationException;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository repository;

    private final EntityManager em;

    @Transactional(readOnly = true)
    public List<Employee> findAll() {
        return repository.findAll();
    }

    @Transactional(readOnly = true)
    public Employee findById(Integer id) {
        return repository.findById(id)
                .orElseThrow(() -> new CommonApplicationException(MessageCode.NOT_FOUND_EMPLOYEE));
    }

    @Transactional(propagation = Propagation.MANDATORY)
    public void updateSalary(Integer departmentId, BigDecimal increaseRate) {
        repository.updateSalary(departmentId, increaseRate);
        em.clear();
        em.flush();
    }

    @Transactional(readOnly = true, propagation = Propagation.MANDATORY)
    public List<String> findJobIdByDepartmentId(Integer departmentId) {
        return repository.findJobIdByDepartmentId(departmentId);
    }

    @Transactional(readOnly = true, propagation = Propagation.MANDATORY)
    public List<Employee> findByDepartmentId(Integer departmentId) {
        return repository.findByDepartmentId(departmentId);
    }

}
