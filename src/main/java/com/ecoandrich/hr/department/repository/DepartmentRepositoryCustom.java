package com.ecoandrich.hr.department.repository;

import com.ecoandrich.hr.payload.department.DepartmentPayloads;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentRepositoryCustom {

    List<DepartmentPayloads.InfoResponse> findAllV1();

    Page<DepartmentPayloads.InfoResponse> findAllV2(Pageable pageable);

    Page<DepartmentPayloads.InfoResponse> findAllV3(DepartmentPayloads.InfoRequest request);
}
