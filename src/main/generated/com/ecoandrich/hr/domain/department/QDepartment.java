package com.ecoandrich.hr.domain.department;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QDepartment is a Querydsl query type for Department
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QDepartment extends EntityPathBase<Department> {

    private static final long serialVersionUID = -183595159L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDepartment department = new QDepartment("department");

    public final StringPath departmentName = createString("departmentName");

    public final SetPath<com.ecoandrich.hr.domain.employee.Employee, com.ecoandrich.hr.domain.employee.QEmployee> employees = this.<com.ecoandrich.hr.domain.employee.Employee, com.ecoandrich.hr.domain.employee.QEmployee>createSet("employees", com.ecoandrich.hr.domain.employee.Employee.class, com.ecoandrich.hr.domain.employee.QEmployee.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final SetPath<com.ecoandrich.hr.domain.job.JobHistory, com.ecoandrich.hr.domain.job.QJobHistory> jobHistories = this.<com.ecoandrich.hr.domain.job.JobHistory, com.ecoandrich.hr.domain.job.QJobHistory>createSet("jobHistories", com.ecoandrich.hr.domain.job.JobHistory.class, com.ecoandrich.hr.domain.job.QJobHistory.class, PathInits.DIRECT2);

    public final QLocation location;

    public final com.ecoandrich.hr.domain.employee.QEmployee manager;

    public QDepartment(String variable) {
        this(Department.class, forVariable(variable), INITS);
    }

    public QDepartment(Path<? extends Department> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QDepartment(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QDepartment(PathMetadata metadata, PathInits inits) {
        this(Department.class, metadata, inits);
    }

    public QDepartment(Class<? extends Department> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.location = inits.isInitialized("location") ? new QLocation(forProperty("location"), inits.get("location")) : null;
        this.manager = inits.isInitialized("manager") ? new com.ecoandrich.hr.domain.employee.QEmployee(forProperty("manager"), inits.get("manager")) : null;
    }

}

