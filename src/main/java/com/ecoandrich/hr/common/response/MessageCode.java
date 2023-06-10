package com.ecoandrich.hr.common.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.Arrays;
import java.util.Optional;

@Getter
@AllArgsConstructor
public enum MessageCode {

    SUCCESS(HttpStatus.OK, "0000"),
    ACCEPTED(HttpStatus.ACCEPTED, "0001"),
    NOT_FOUND_DATA(HttpStatus.BAD_REQUEST, "9997"),
    ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "9998"),
    EXCEPTION_ILLEGAL_ARGUMENT(HttpStatus.BAD_REQUEST, "9100"),

    NOT_FOUND_EMPLOYEE(HttpStatus.BAD_REQUEST, "6001"),
    NOT_FOUND_DEPARTMENT(HttpStatus.BAD_REQUEST, "7001");


    private final HttpStatus httpStatus;
    private final String code;

    public static Optional<MessageCode> get(String name) {
        return Arrays.stream(MessageCode.values())
                .filter(env -> env.name().equals(name))
                .findFirst();
    }

}
