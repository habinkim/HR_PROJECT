package com.ecoandrich.hr.employee.mapper;

import com.ecoandrich.hr.common.config.BaseMapperConfig;
import com.ecoandrich.hr.domain.employee.Employee;
import com.ecoandrich.hr.payload.employee.EmployeePayloads;
import org.mapstruct.IterableMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.List;

@Mapper(config = BaseMapperConfig.class)
public interface EmployeeMapper {

    @IterableMapping(qualifiedByName = "infoResponse")
    List<EmployeePayloads.InfoResponse> infoResponses(List<Employee> employees);

    @Named("infoResponse")
    @Mapping(target = "jobId", source = "job.jobId")
    @Mapping(target = "jobTitle", source = "job.jobTitle")
    @Mapping(target = "managerId", source = "manager.id")
    @Mapping(target = "managerFirstName", source = "manager.firstName")
    @Mapping(target = "managerLastName", source = "manager.lastName")
    @Mapping(target = "departmentId", source = "department.id")
    @Mapping(target = "departmentName", source = "department.departmentName")
    EmployeePayloads.InfoResponse infoResponse(Employee employee);

}
