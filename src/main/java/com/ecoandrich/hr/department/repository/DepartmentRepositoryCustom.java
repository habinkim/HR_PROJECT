package com.ecoandrich.hr.department.repository;

import com.ecoandrich.hr.payload.department.DepartmentPayloads;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface DepartmentRepositoryCustom {

    List<DepartmentPayloads.InfoResponse> findAllWithProjection();

    Page<DepartmentPayloads.InfoResponse> findAllWithProjectionAndPaging(Pageable pageable);

}
