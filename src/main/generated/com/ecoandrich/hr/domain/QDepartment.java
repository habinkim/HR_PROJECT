package com.ecoandrich.hr.domain;

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

    private static final long serialVersionUID = -454984073L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QDepartment department = new QDepartment("department");

    public final StringPath departmentName = createString("departmentName");

    public final SetPath<Employee, QEmployee> employees = this.<Employee, QEmployee>createSet("employees", Employee.class, QEmployee.class, PathInits.DIRECT2);

    public final NumberPath<Integer> id = createNumber("id", Integer.class);

    public final SetPath<JobHistory, QJobHistory> jobHistories = this.<JobHistory, QJobHistory>createSet("jobHistories", JobHistory.class, QJobHistory.class, PathInits.DIRECT2);

    public final QLocation location;

    public final QEmployee manager;

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
        this.manager = inits.isInitialized("manager") ? new QEmployee(forProperty("manager"), inits.get("manager")) : null;
    }

}

