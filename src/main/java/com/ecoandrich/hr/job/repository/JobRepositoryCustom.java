package com.ecoandrich.hr.job.repository;

import java.math.BigDecimal;
import java.util.List;

public interface JobRepositoryCustom {

    void updateSalary(List<String> jobIds, BigDecimal increaseRate);

}
