package com.ecoandrich.hr.payload.department;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.math.BigDecimal;

public class DepartmentPayloads {
    public record InfoRequest(
            @Min(value = 0, message = "페이지 번호는 0 이상이어야 합니다.") Integer page,
            @Min(value = 1, message = "페이지당 크기는 1 이상이어야 합니다.") Integer size,
            Integer departmentId,
            String departmentName,
            Integer managerId,
            String managerName,
            Integer locationId,
            String streetAddress,
            String countryId,
            String countryName,
            Integer regionId,
            String regionName
    ) {
    }

    public record SalaryRequest(
            @NotNull(message = "부서 ID를 입력하지 않으셨습니다.") Integer departmentId,
            @NotNull(message = "인상률을 입력하지 않으셨습니다.") BigDecimal increaseRate
            ) {
    }

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoResponse {

        private Integer departmentId;
        private String departmentName;

        private Integer managerId;
        private String managerFirstName;
        private String managerLastName;
        private String managerEmail;
        private String managerPhoneNumber;

        private Integer locationId;
        private String streetAddress;
        private String postalCode;
        private String city;
        private String stateProvince;

        private String countryId;
        private String countryName;

        private Integer regionId;
        private String regionName;

    }
}
