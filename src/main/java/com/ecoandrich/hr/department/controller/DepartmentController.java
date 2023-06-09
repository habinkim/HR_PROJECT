package com.ecoandrich.hr.department.controller;

import com.ecoandrich.hr.common.config.Uris;
import com.ecoandrich.hr.common.response.BaseResponse;
import com.ecoandrich.hr.common.response.ResponseMapper;
import com.ecoandrich.hr.department.service.DepartmentService;
import com.ecoandrich.hr.payload.department.DepartmentPayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class DepartmentController {

    private final DepartmentService service;
    private final ResponseMapper responseMapper;

    /**
     * 부서 및 위치 정보 조회 API - no Paging
     * @return List<DepartmentPayloads.InfoResponse>
     */
    @GetMapping(value = Uris.DEPARTMENT_ROOT + "/v1")
    public ResponseEntity<BaseResponse> listV1() {
        List<DepartmentPayloads.InfoResponse> list = service.findAllV1();
        return responseMapper.ok(list);
    }

    /**
     * 부서 및 위치 정보 조회 API - with Paging
     * @return List<DepartmentPayloads.InfoResponse>
     */
    @GetMapping(value = Uris.DEPARTMENT_ROOT + "/v2")
    public ResponseEntity<BaseResponse> listV2(@PageableDefault(sort = "departmentName", direction = Sort.Direction.ASC) Pageable pageable) {
        Page<DepartmentPayloads.InfoResponse> list = service.findAllV2(pageable);
        return responseMapper.ok(list);
    }

}
