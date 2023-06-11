package com.ecoandrich.hr.external.service;

import com.ecoandrich.hr.common.util.StringUtils;
import com.ecoandrich.hr.payload.openapi.OpenAPIPayloads;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class OpenAPIService {

    private final RestTemplate restTemplate;
    private final StringUtils stringUtils;
    private final ObjectMapper objectMapper;

    private static final String CROSSWALK_OPEN_API_URL = "https://apis.data.go.kr/3190000/CrossWalkService/getCrossWalkList";

    private static final String OPEN_API_SERVICE_KEY = "urDdz4/3XdpAKGM5vbR0MBjuCdkIZk7vIv2Ta/scOStZLAPK9FKbCSMd87gsDGsUqpZ7DOWh3hAZla3ZI/Ubuw==";

    public OpenAPIPayloads.CrossWalkResponse crossWalk(Pageable pageable) throws JsonProcessingException {
        HttpEntity<Object> httpEntity = new HttpEntity<>(new HttpHeaders());
        URI uri = buildOpenApiUri(pageable);

        log.info("openApi URI : {}", uri);
        Object response = restTemplate.exchange(uri, HttpMethod.GET, httpEntity, Object.class).getBody();
        OpenAPIPayloads.CrossWalkResponse crossWalkResponse = objectMapper.readValue(objectMapper.writeValueAsString(response), new TypeReference<>() {
        });
        log.info("OpenAPIPayloads.CrossWalkResponse : \n{}", stringUtils.objectToPrettyJson(crossWalkResponse));

        return crossWalkResponse;
    }

    private static URI buildOpenApiUri(Pageable pageable) {
        String decodeServiceKey = URLDecoder.decode(OPEN_API_SERVICE_KEY, StandardCharsets.UTF_8);

        return UriComponentsBuilder.fromHttpUrl(CROSSWALK_OPEN_API_URL)
                .queryParam("serviceKey", decodeServiceKey)
                .queryParam("pageNo", pageable.getPageNumber() + 1)
                .queryParam("numOfRows", pageable.getPageSize())
                .build()
                .toUri();
    }


}
