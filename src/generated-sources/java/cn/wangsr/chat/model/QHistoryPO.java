package cn.wangsr.chat.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QHistoryPO is a Querydsl query type for HistoryPO
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QHistoryPO extends EntityPathBase<HistoryPO> {

    private static final long serialVersionUID = -59050463L;

    public static final QHistoryPO historyPO = new QHistoryPO("historyPO");

    public final DateTimePath<java.time.LocalDateTime> createTime = createDateTime("createTime", java.time.LocalDateTime.class);

    public final NumberPath<Long> creatorId = createNumber("creatorId", Long.class);

    public final StringPath creatorName = createString("creatorName");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Integer> isAlive = createNumber("isAlive", Integer.class);

    public final StringPath participators = createString("participators");

    public final NumberPath<Long> roomId = createNumber("roomId", Long.class);

    public QHistoryPO(String variable) {
        super(HistoryPO.class, forVariable(variable));
    }

    public QHistoryPO(Path<? extends HistoryPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QHistoryPO(PathMetadata metadata) {
        super(HistoryPO.class, metadata);
    }

}

