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

    /**
     * 업무 ID
     */
    @Id
    @Column(name = "job_id", nullable = false, length = 10)
    private String jobId;

    /**
     * 업무명
     */
    @Column(name = "job_title", nullable = false, length = 35)
    private String jobTitle;

    /**
     * 최소 봉급
     */
    @Column(name = "min_salary", precision = 8)
    private BigDecimal minSalary;

    /**
     * 최대 봉급
     */
    @Column(name = "max_salary", precision = 8)
    private BigDecimal maxSalary;

}
