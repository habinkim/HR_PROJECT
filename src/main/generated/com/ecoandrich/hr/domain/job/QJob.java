package com.ecoandrich.hr.domain.job;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QJob is a Querydsl query type for Job
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJob extends EntityPathBase<Job> {

    private static final long serialVersionUID = 998443271L;

    public static final QJob job = new QJob("job");

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

