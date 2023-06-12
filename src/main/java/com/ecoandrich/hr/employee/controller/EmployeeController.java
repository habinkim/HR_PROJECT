package com.ecoandrich.hr.employee.controller;

import com.ecoandrich.hr.common.config.Uris;
import com.ecoandrich.hr.common.response.BaseResponse;
import com.ecoandrich.hr.common.response.ResponseMapper;
import com.ecoandrich.hr.employee.mapper.EmployeeMapper;
import com.ecoandrich.hr.employee.service.EmployeeService;
import com.ecoandrich.hr.payload.employee.EmployeePayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService service;
    private final EmployeeMapper employeeMapper;
    private final ResponseMapper responseMapper;

    /**
     * 사원 현재 정보 조회 API
     * @return List<EmployeePayloads.InfoResponse>
     */
    @GetMapping(value = Uris.EMPLOYEE_ROOT)
    public ResponseEntity<BaseResponse> infoList() {
        List<EmployeePayloads.InfoResponse> infoResponses = employeeMapper.infoResponses(service.findAll());
        return responseMapper.ok(infoResponses);
    }

    /**
     * 특정 사원 현재 정보 조회 API
     * @param id
     * @return EmployeePayloads.InfoResponse
     */
    @GetMapping(value = Uris.EMPLOYEE_ROOT + Uris.REST_NAME_ID)
    public ResponseEntity<BaseResponse> info(@PathVariable Integer id) {
        EmployeePayloads.InfoResponse infoResponse = employeeMapper.infoResponse(service.findById(id));
        return responseMapper.ok(infoResponse);
    }

}
