package com.ecoandrich.hr.department.service;

import com.ecoandrich.hr.department.repository.DepartmentRepository;
import com.ecoandrich.hr.payload.department.DepartmentPayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class DepartmentService {

    private final DepartmentRepository repository;

    @Transactional(readOnly = true)
    public List<DepartmentPayloads.InfoResponse> findAllV1() {
        return repository.findAllWithProjection();
    }

    @Transactional(readOnly = true)
    public Page<DepartmentPayloads.InfoResponse> findAllV2(Pageable pageable) {
        return repository.findAllWithProjectionAndPaging(pageable);
    }
}
