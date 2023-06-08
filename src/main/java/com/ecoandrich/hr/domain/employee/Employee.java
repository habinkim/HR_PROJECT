package com.ecoandrich.hr.domain.employee;

import com.ecoandrich.hr.domain.job.Job;
import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Set;

/**
 * 사원 Entity 클래스
 */
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "employees")
public class Employee {

    /**
     * 사원 아이디
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable = false)
    private Integer id;

    /**
     * 성
     */
    @Column(name = "first_name", length = 20)
    private String firstName;

    /**
     * 이름
     */
    @Column(name = "last_name", nullable = false, length = 25)
    private String lastName;

    /**
     * 이메일
     */
    @Column(name = "email", nullable = false, length = 25)
    private String email;

    /**
     * 전화번호
     */
    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    /**
     * 고용일
     */
    @Column(name = "hire_date", nullable = false)
    private LocalDate hireDate;

    /**
     * 직무
     */
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    /**
     * 봉급
     */
    @Column(name = "salary", nullable = false, precision = 8, scale = 2)
    private BigDecimal salary;

    /**
     * 커미션 비율
     */
    @Column(name = "commission_pct", precision = 2, scale = 2)
    private BigDecimal commissionPct;

    /**
     * 상사
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Employee manager;

    /**
     * 부서
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_id")
    private Department department;

}
