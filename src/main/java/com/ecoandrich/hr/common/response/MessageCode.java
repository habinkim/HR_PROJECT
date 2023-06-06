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
    CREATED(HttpStatus.CREATED, "0001"),
    ACCEPTED(HttpStatus.ACCEPTED, "0002"),
    NOT_OWNER(HttpStatus.UNAUTHORIZED, "9997"),
    NOT_FOUND_DATA(HttpStatus.BAD_REQUEST, "9998"),
    ERROR(HttpStatus.INTERNAL_SERVER_ERROR, "9999"),
    EXCEPTION_ILLEGAL_ARGUMENT(HttpStatus.BAD_REQUEST, "9100");


    private HttpStatus httpStatus;
    private String code;

    public static Optional<MessageCode> get(String name) {
        return Arrays.stream(MessageCode.values())
                .filter(env -> env.name().equals(name))
                .findFirst();
    }

}
