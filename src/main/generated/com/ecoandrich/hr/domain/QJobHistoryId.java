package com.ecoandrich.hr.domain;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJobHistoryId is a Querydsl query type for JobHistoryId
 */
@Generated("com.querydsl.codegen.DefaultEmbeddableSerializer")
public class QJobHistoryId extends BeanPath<JobHistoryId> {

    private static final long serialVersionUID = -1953396873L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJobHistoryId jobHistoryId = new QJobHistoryId("jobHistoryId");

    public final QEmployee employee;

    public final DatePath<java.time.LocalDate> startDate = createDate("startDate", java.time.LocalDate.class);

    public QJobHistoryId(String variable) {
        this(JobHistoryId.class, forVariable(variable), INITS);
    }

    public QJobHistoryId(Path<? extends JobHistoryId> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJobHistoryId(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJobHistoryId(PathMetadata metadata, PathInits inits) {
        this(JobHistoryId.class, metadata, inits);
    }

    public QJobHistoryId(Class<? extends JobHistoryId> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.employee = inits.isInitialized("employee") ? new QEmployee(forProperty("employee"), inits.get("employee")) : null;
    }

}

