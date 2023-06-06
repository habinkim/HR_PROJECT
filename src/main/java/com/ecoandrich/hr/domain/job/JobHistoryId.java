package com.ecoandrich.hr.domain.job;

import com.ecoandrich.hr.domain.employee.Employee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;

@Embeddable
public class JobHistoryId implements Serializable {

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "employee_id", nullable = false)
    private Employee employee;

    @Column(name = "start_date", nullable = false)
    private LocalDate startDate;

}
