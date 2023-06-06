package com.ecoandrich.hr.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QEmployee is a Querydsl query type for Employee
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QEmployee extends EntityPathBase<Employee> {

    private static final long serialVersionUID = -488331501L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QEmployee employee = new QEmployee("employee");

    public final NumberPath<java.math.BigDecimal> commissionPct = createNumber("commissionPct", java.math.BigDecimal.class);

    public final QDepartment department;

    public final SetPath<Department, QDepartment> departments = this.<Department, QDepartment>createSet("departments", Department.class, QDepartment.class, PathInits.DIRECT2);

    public final StringPath email = createString("email");

    public final SetPath<Employee, QEmployee> employees = this.<Employee, QEmployee>createSet("employees", Employee.class, QEmployee.class, PathInits.DIRECT2);

    public final StringPath firstName = createString("firstName");

    public final DatePath<java.time.LocalDate> hireDate = createDate("hireDate", java.time.LocalDate.class);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final QJob job;

    public final StringPath lastName = createString("lastName");

    public final QEmployee manager;

    public final StringPath phoneNumber = createString("phoneNumber");

    public final NumberPath<java.math.BigDecimal> salary = createNumber("salary", java.math.BigDecimal.class);

    public QEmployee(String variable) {
        this(Employee.class, forVariable(variable), INITS);
    }

    public QEmployee(Path<? extends Employee> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QEmployee(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QEmployee(PathMetadata metadata, PathInits inits) {
        this(Employee.class, metadata, inits);
    }

    public QEmployee(Class<? extends Employee> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new QDepartment(forProperty("department"), inits.get("department")) : null;
        this.job = inits.isInitialized("job") ? new QJob(forProperty("job")) : null;
        this.manager = inits.isInitialized("manager") ? new QEmployee(forProperty("manager"), inits.get("manager")) : null;
    }

}

