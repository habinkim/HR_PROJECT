package com.ecoandrich.hr.domain.job;

import com.ecoandrich.hr.domain.employee.Employee;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.util.LinkedHashSet;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "jobs")
public class Job {
    @Id
    @Column(name = "job_id", nullable = false, length = 10)
    private String jobId;

    @Column(name = "job_title", nullable = false, length = 35)
    private String jobTitle;

    @Column(name = "min_salary", precision = 8)
    private BigDecimal minSalary;

    @Column(name = "max_salary", precision = 8)
    private BigDecimal maxSalary;

    @Builder.Default
    @OneToMany(mappedBy = "job")
    private Set<Employee> employees = new LinkedHashSet<>();

    @Builder.Default
    @OneToMany(mappedBy = "job")
    private Set<JobHistory> jobHistories = new LinkedHashSet<>();

}
