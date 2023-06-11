package com.ecoandrich.hr.external.controller;

import com.ecoandrich.hr.common.config.Uris;
import com.ecoandrich.hr.common.response.BaseResponse;
import com.ecoandrich.hr.common.response.ResponseMapper;
import com.ecoandrich.hr.external.service.OpenAPIService;
import com.ecoandrich.hr.payload.openapi.OpenAPIPayloads;
import com.fasterxml.jackson.core.JsonProcessingException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class OpenAPIController {

    private final OpenAPIService service;
    private final ResponseMapper responseMapper;

    @GetMapping(value = Uris.OPEN_API_ROOT + "/crossWalk")
    public ResponseEntity<BaseResponse> crossWalk(Pageable pageable) throws JsonProcessingException {
        OpenAPIPayloads.CrossWalkResponse response = service.crossWalk(pageable);
        return responseMapper.ok(response);
    }
}
