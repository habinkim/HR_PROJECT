package com.ecoandrich.hr.department.repository;

import com.ecoandrich.hr.payload.department.DepartmentPayloads;
import com.querydsl.core.types.Projections;
import com.querydsl.jpa.impl.JPAQuery;
import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.support.PageableExecutionUtils;

import java.util.List;

import static com.ecoandrich.hr.domain.department.QCountry.country;
import static com.ecoandrich.hr.domain.department.QDepartment.department;
import static com.ecoandrich.hr.domain.department.QLocation.location;
import static com.ecoandrich.hr.domain.department.QRegion.region;
import static com.ecoandrich.hr.domain.employee.QEmployee.employee;

@RequiredArgsConstructor
public class DepartmentRepositoryCustomImpl implements DepartmentRepositoryCustom {

    private final JPAQueryFactory queryFactory;

    public JPAQuery<DepartmentPayloads.InfoResponse> fetchQuery() {
        return queryFactory.select(Projections.fields(DepartmentPayloads.InfoResponse.class,
                        department.id.as("departmentId"),
                        department.departmentName,
                        employee.id.as("managerId"),
                        employee.firstName.as("managerFirstName"),
                        employee.lastName.as("managerLastName"),
                        employee.email.as("managerEmail"),
                        employee.phoneNumber.as("managerPhoneNumber"),
                        location.id.as("locationId"),
                        location.streetAddress,
                        location.postalCode,
                        location.city,
                        location.stateProvince,
                        country.countryId,
                        country.countryName,
                        region.id.as("regionId"),
                        region.regionName
                ))
                .from(department)
                .leftJoin(department.manager, employee)
                .leftJoin(department.location, location)
                .join(location.country, country)
                .join(country.region, region)
                .orderBy(department.departmentName.asc());
    }

    @Override
    public List<DepartmentPayloads.InfoResponse> findAllWithProjection() {
        return fetchQuery().fetch();
    }

    @Override
    public Page<DepartmentPayloads.InfoResponse> findAllWithProjectionAndPaging(Pageable pageable) {
        List<DepartmentPayloads.InfoResponse> fetch = fetchQuery()
                .offset(pageable.getOffset())
                .limit(pageable.getPageSize())
                .fetch();

        JPAQuery<Long> countQuery = queryFactory.select(department.id.count())
                .from(department)
                .leftJoin(department.manager, employee)
                .leftJoin(department.location, location)
                .join(location.country, country)
                .join(country.region, region);

        return PageableExecutionUtils.getPage(fetch, pageable, countQuery::fetchOne);
    }
}
