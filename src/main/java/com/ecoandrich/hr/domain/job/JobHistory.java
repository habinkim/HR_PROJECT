package com.ecoandrich.hr.domain.job;

import com.ecoandrich.hr.domain.department.Department;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Entity
@Table(name = "job_history", uniqueConstraints = @UniqueConstraint(name = "employee_id", columnNames = {"employee_id", "start_date"}))
public class JobHistory {

    @EmbeddedId
    private JobHistoryId id;

    @Column(name = "end_date", nullable = false)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "job_id", nullable = false)
    private Job job;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "department_id", nullable = false)
    private Department department;

}
