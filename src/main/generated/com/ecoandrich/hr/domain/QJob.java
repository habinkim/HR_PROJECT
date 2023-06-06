package com.ecoandrich.hr.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJob is a Querydsl query type for Job
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJob extends EntityPathBase<Job> {

    private static final long serialVersionUID = 1430810680L;

    public static final QJob job = new QJob("job");

    public final SetPath<Employee, QEmployee> employees = this.<Employee, QEmployee>createSet("employees", Employee.class, QEmployee.class, PathInits.DIRECT2);

    public final SetPath<JobHistory, QJobHistory> jobHistories = this.<JobHistory, QJobHistory>createSet("jobHistories", JobHistory.class, QJobHistory.class, PathInits.DIRECT2);

    public final StringPath jobId = createString("jobId");

    public final StringPath jobTitle = createString("jobTitle");

    public final NumberPath<java.math.BigDecimal> maxSalary = createNumber("maxSalary", java.math.BigDecimal.class);

    public final NumberPath<java.math.BigDecimal> minSalary = createNumber("minSalary", java.math.BigDecimal.class);

    public QJob(String variable) {
        super(Job.class, forVariable(variable));
    }

    public QJob(Path<? extends Job> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJob(PathMetadata metadata) {
        super(Job.class, metadata);
    }

}

