package com.ecoandrich.hr.domain.job;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QJobHistory is a Querydsl query type for JobHistory
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QJobHistory extends EntityPathBase<JobHistory> {

    private static final long serialVersionUID = -1219392115L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QJobHistory jobHistory = new QJobHistory("jobHistory");

    public final com.ecoandrich.hr.domain.employee.QDepartment department;

    public final DatePath<java.time.LocalDate> endDate = createDate("endDate", java.time.LocalDate.class);

    public final QJobHistoryId id;

    public final QJob job;

    public QJobHistory(String variable) {
        this(JobHistory.class, forVariable(variable), INITS);
    }

    public QJobHistory(Path<? extends JobHistory> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QJobHistory(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QJobHistory(PathMetadata metadata, PathInits inits) {
        this(JobHistory.class, metadata, inits);
    }

    public QJobHistory(Class<? extends JobHistory> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.department = inits.isInitialized("department") ? new com.ecoandrich.hr.domain.employee.QDepartment(forProperty("department"), inits.get("department")) : null;
        this.id = inits.isInitialized("id") ? new QJobHistoryId(forProperty("id"), inits.get("id")) : null;
        this.job = inits.isInitialized("job") ? new QJob(forProperty("job")) : null;
    }

}

