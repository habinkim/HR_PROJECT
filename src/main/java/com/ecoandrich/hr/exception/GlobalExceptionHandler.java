package com.ecoandrich.hr.exception;

import com.ecoandrich.hr.common.response.BaseExceptionResponse;
import com.ecoandrich.hr.common.response.MessageCode;
import com.ecoandrich.hr.common.response.ResponseMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

@Slf4j
@RestControllerAdvice
@RequiredArgsConstructor
public class GlobalExceptionHandler {

    private final ResponseMapper responseMapper;

    @ExceptionHandler(CommonApplicationException.class)
    protected ResponseEntity<BaseExceptionResponse> commonApplicationException(CommonApplicationException e) {
        show(e);
        if (e.getMessageCode() == null) {
            return responseMapper.error(MessageCode.ERROR);
        } else {
            return responseMapper.error(e.getMessageCode());
        }
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<BaseExceptionResponse> illegalArgumentExceptionHandle(MethodArgumentNotValidException e) {
        show(e);
        return responseMapper.error(MessageCode.EXCEPTION_ILLEGAL_ARGUMENT);
    }

    @ExceptionHandler(MissingServletRequestParameterException.class)
    protected ResponseEntity<BaseExceptionResponse> missingServletRequestParameterExceptionHandle(MissingServletRequestParameterException e) {
        show(e);
        return responseMapper.error(MessageCode.EXCEPTION_ILLEGAL_ARGUMENT);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    protected ResponseEntity<BaseExceptionResponse> methodArgumentTypeMismatchExceptionHandle(MethodArgumentTypeMismatchException e) {
        show(e);
        return responseMapper.error(MessageCode.EXCEPTION_ILLEGAL_ARGUMENT);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<BaseExceptionResponse> allExceptionHandle(Exception e) {
        show(e);
        return responseMapper.error(MessageCode.ERROR);
    }

    private void show(Exception e) {
        e.printStackTrace();;
    }

}
