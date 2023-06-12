package com.ecoandrich.hr.employee.mapper;

import com.ecoandrich.hr.domain.department.Department;
import com.ecoandrich.hr.domain.employee.Employee;
import com.ecoandrich.hr.domain.job.Job;
import com.ecoandrich.hr.payload.employee.EmployeePayloads;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-06-12T13:26:58+0900",
    comments = "version: 1.5.5.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 18.0.2.1 (Oracle Corporation)"
)
@Component
public class EmployeeMapperImpl implements EmployeeMapper {

    @Override
    public List<EmployeePayloads.InfoResponse> infoResponses(List<Employee> employees) {
        if ( employees == null ) {
            return null;
        }

        List<EmployeePayloads.InfoResponse> list = new ArrayList<EmployeePayloads.InfoResponse>( employees.size() );
        for ( Employee employee : employees ) {
            list.add( infoResponse( employee ) );
        }

        return list;
    }

    @Override
    public EmployeePayloads.InfoResponse infoResponse(Employee employee) {
        if ( employee == null ) {
            return null;
        }

        EmployeePayloads.InfoResponse.InfoResponseBuilder infoResponse = EmployeePayloads.InfoResponse.builder();

        String jobId = employeeJobJobId( employee );
        if ( jobId != null ) {
            infoResponse.jobId( jobId );
        }
        String jobTitle = employeeJobJobTitle( employee );
        if ( jobTitle != null ) {
            infoResponse.jobTitle( jobTitle );
        }
        Integer id = employeeManagerId( employee );
        if ( id != null ) {
            infoResponse.managerId( id );
        }
        String firstName = employeeManagerFirstName( employee );
        if ( firstName != null ) {
            infoResponse.managerFirstName( firstName );
        }
        String lastName = employeeManagerLastName( employee );
        if ( lastName != null ) {
            infoResponse.managerLastName( lastName );
        }
        Integer id1 = employeeDepartmentId( employee );
        if ( id1 != null ) {
            infoResponse.departmentId( id1 );
        }
        String departmentName = employeeDepartmentDepartmentName( employee );
        if ( departmentName != null ) {
            infoResponse.departmentName( departmentName );
        }
        if ( employee.getId() != null ) {
            infoResponse.id( employee.getId() );
        }
        if ( employee.getFirstName() != null ) {
            infoResponse.firstName( employee.getFirstName() );
        }
        if ( employee.getLastName() != null ) {
            infoResponse.lastName( employee.getLastName() );
        }
        if ( employee.getEmail() != null ) {
            infoResponse.email( employee.getEmail() );
        }
        if ( employee.getPhoneNumber() != null ) {
            infoResponse.phoneNumber( employee.getPhoneNumber() );
        }
        if ( employee.getHireDate() != null ) {
            infoResponse.hireDate( employee.getHireDate() );
        }
        if ( employee.getSalary() != null ) {
            infoResponse.salary( employee.getSalary() );
        }
        if ( employee.getCommissionPct() != null ) {
            infoResponse.commissionPct( employee.getCommissionPct() );
        }

        return infoResponse.build();
    }

    private String employeeJobJobId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Job job = employee.getJob();
        if ( job == null ) {
            return null;
        }
        String jobId = job.getJobId();
        if ( jobId == null ) {
            return null;
        }
        return jobId;
    }

    private String employeeJobJobTitle(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Job job = employee.getJob();
        if ( job == null ) {
            return null;
        }
        String jobTitle = job.getJobTitle();
        if ( jobTitle == null ) {
            return null;
        }
        return jobTitle;
    }

    private Integer employeeManagerId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Employee manager = employee.getManager();
        if ( manager == null ) {
            return null;
        }
        Integer id = manager.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String employeeManagerFirstName(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Employee manager = employee.getManager();
        if ( manager == null ) {
            return null;
        }
        String firstName = manager.getFirstName();
        if ( firstName == null ) {
            return null;
        }
        return firstName;
    }

    private String employeeManagerLastName(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Employee manager = employee.getManager();
        if ( manager == null ) {
            return null;
        }
        String lastName = manager.getLastName();
        if ( lastName == null ) {
            return null;
        }
        return lastName;
    }

    private Integer employeeDepartmentId(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Department department = employee.getDepartment();
        if ( department == null ) {
            return null;
        }
        Integer id = department.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private String employeeDepartmentDepartmentName(Employee employee) {
        if ( employee == null ) {
            return null;
        }
        Department department = employee.getDepartment();
        if ( department == null ) {
            return null;
        }
        String departmentName = department.getDepartmentName();
        if ( departmentName == null ) {
            return null;
        }
        return departmentName;
    }
}
