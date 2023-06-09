package com.ecoandrich.hr.payload.department;

import lombok.*;

public class DepartmentPayloads {

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
