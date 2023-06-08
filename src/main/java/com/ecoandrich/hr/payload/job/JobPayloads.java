package com.ecoandrich.hr.payload.job;

import lombok.*;

import java.time.LocalDate;

public class JobPayloads {

    @Builder
    @Getter
    @EqualsAndHashCode(callSuper = false)
    @NoArgsConstructor
    @AllArgsConstructor
    public static class HistoryResponse {

        private Integer employeeId;
        private String firstName;
        private String lastName;

        private LocalDate startDate;
        private LocalDate endDate;

        private String jobId;
        private String jobTitle;

        private Integer departmentId;
        private String departmentName;

    }

}
