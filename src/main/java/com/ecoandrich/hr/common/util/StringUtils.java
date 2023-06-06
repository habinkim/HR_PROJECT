package com.ecoandrich.hr.common.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import org.springframework.stereotype.Component;

import java.security.SecureRandom;
import java.util.Date;
import java.util.UUID;

@Component
public class StringUtils {
    public String uuidGenerator() {
        return UUID.randomUUID().toString();
    }

    public String objectToJson(Object object) throws JsonProcessingException {
        ObjectMapper mapper = new ObjectMapper();
        mapper.registerModule(new JavaTimeModule());
        return mapper.writeValueAsString(object);
    }

    public String objectToPrettyJson(Object object) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        return objectMapper.writerWithDefaultPrettyPrinter().writeValueAsString(object);
    }

    public boolean hasText(String text) {
        return org.springframework.util.StringUtils.hasText(text);
    }

    /**
     * TODO 제대로 된 재발급 처리가 되도록 수정해야 함. (영문자, 숫자 각각 반드시 한개 이상씩 들어가게)
     */
    final char[] passwordCharSet = new char[] {
            'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'};
    public String randomString(int size) {
        SecureRandom sr = new SecureRandom();
        sr.setSeed(new Date().getTime());
        StringBuffer sb = new StringBuffer();

        for (int i = 0; i < size - 1; i++) {
            sb.append(passwordCharSet[sr.nextInt(passwordCharSet.length)]);
        }

        return sb.append('0').toString();
    }
}
