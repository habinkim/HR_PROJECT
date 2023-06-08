package com.ecoandrich.hr.payload.employee;

import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;

public class EmployeePayloads {

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class InfoResponse {

        private Integer id;
        private String firstName;
        private String lastName;
        private String email;
        private String phoneNumber;
        private LocalDate hireDate;

        private String jobId;
        private String jobTitle;

        private BigDecimal salary;
        private BigDecimal commissionPct;

        private Integer managerId;
        private String managerFirstName;
        private String managerLastName;

        private Integer departmentId;
        private String departmentName;

    }

}
