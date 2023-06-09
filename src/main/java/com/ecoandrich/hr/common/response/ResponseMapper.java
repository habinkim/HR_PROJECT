package com.ecoandrich.hr.common.response;

import com.ecoandrich.hr.common.util.MessageSourceUtil;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class ResponseMapper {

    private final MessageSourceUtil messageSourceUtil;

    public ResponseEntity<BaseResponse> ok() {
        return ResponseEntity.ok().body(new BaseResponse<>(MessageCode.SUCCESS.name(), null));
    }

    private <T> ResponseEntity<BaseResponse> ok(final MessageCode messageCode, final T source) {
        return ResponseEntity.ok().body(new BaseResponse<>(messageCode.name(), source));
    }

    public <T> ResponseEntity<BaseResponse> ok(final T source) {
        return ok(MessageCode.SUCCESS, source);
    }

    public ResponseEntity<BaseExceptionResponse> error(final MessageCode messageCode) {
        return ResponseEntity
                .status(messageCode.getHttpStatus())
                .body(new BaseExceptionResponse(messageSourceUtil.getMessage(messageCode.getCode()), messageCode.getCode()));
    }

}
