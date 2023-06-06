package com.ecoandrich.hr.common.response;

import com.fasterxml.jackson.annotation.JsonInclude;

public record BaseResponse<T>(String message, @JsonInclude(JsonInclude.Include.NON_NULL) T result) {
}
