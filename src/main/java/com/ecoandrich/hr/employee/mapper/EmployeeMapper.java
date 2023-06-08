package com.ecoandrich.hr.employee.mapper;

import com.ecoandrich.hr.common.config.BaseMapperConfig;
import com.ecoandrich.hr.domain.employee.Employee;
import com.ecoandrich.hr.payload.employee.EmployeePayloads;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(config = BaseMapperConfig.class)
public interface EmployeeMapper {

    @Mapping(target = "jobId", source = "job.jobId")
    @Mapping(target = "jobTitle", source = "job.jobTitle")
    @Mapping(target = "managerId", source = "manager.id")
    @Mapping(target = "managerFirstName", source = "manager.firstName")
    @Mapping(target = "managerLastName", source = "manager.lastName")
    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "departmentName", source = "department.departmentName")
    EmployeePayloads.InfoResponse infoResponse(Employee employee);

}
