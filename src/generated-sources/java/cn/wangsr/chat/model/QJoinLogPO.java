package cn.wangsr.chat.model;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QJoinLogPO is a Querydsl query type for JoinLogPO
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QJoinLogPO extends EntityPathBase<JoinLogPO> {

    private static final long serialVersionUID = 1998628295L;

    public static final QJoinLogPO joinLogPO = new QJoinLogPO("joinLogPO");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final NumberPath<Long> joinChat = createNumber("joinChat", Long.class);

    public final NumberPath<Long> joinerId = createNumber("joinerId", Long.class);

    public final DateTimePath<java.time.LocalDateTime> joinTime = createDateTime("joinTime", java.time.LocalDateTime.class);

    public QJoinLogPO(String variable) {
        super(JoinLogPO.class, forVariable(variable));
    }

    public QJoinLogPO(Path<? extends JoinLogPO> path) {
        super(path.getType(), path.getMetadata());
    }

    public QJoinLogPO(PathMetadata metadata) {
        super(JoinLogPO.class, metadata);
    }

}

