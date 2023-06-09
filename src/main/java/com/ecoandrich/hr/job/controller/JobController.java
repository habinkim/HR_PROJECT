package com.ecoandrich.hr.job.controller;

import com.ecoandrich.hr.common.config.Uris;
import com.ecoandrich.hr.common.response.BaseResponse;
import com.ecoandrich.hr.common.response.ResponseMapper;
import com.ecoandrich.hr.job.service.JobService;
import com.ecoandrich.hr.payload.job.JobPayloads;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class JobController {

    private final JobService service;
    private final ResponseMapper responseMapper;

    /**
     * 특정 사원의 업무 이력 정보 조회 API - no Paging
     *
     * @param id
     * @return List<JobPayloads.HistoryResponse>
     */
    @GetMapping(value = Uris.JOB_ROOT + "/v1" + Uris.REST_NAME_ID)
    public ResponseEntity<BaseResponse> history(@PathVariable Integer id) {
        List<JobPayloads.HistoryResponse> historyResponse = service.history(id);
        return responseMapper.ok(historyResponse);
    }

    /**
     * 특정 사원의 업무 이력 정보 조회 API - with Paging
     * @param id
     * @param pageable
     * @return Page<JobPayloads.HistoryResponse>
     */
    @GetMapping(value = Uris.JOB_ROOT + "/v2" + Uris.REST_NAME_ID)
    public ResponseEntity<BaseResponse> historyWithPaging(
            @PathVariable Integer id,
            @PageableDefault(sort = "endDate", direction = Sort.Direction.DESC) Pageable pageable) {
        Page<JobPayloads.HistoryResponse> historyResponse = service.historyWithPaging(id, pageable);
        return responseMapper.ok(historyResponse);
    }

}
