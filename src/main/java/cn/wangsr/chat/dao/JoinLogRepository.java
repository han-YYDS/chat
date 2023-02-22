package cn.wangsr.chat.dao;

import cn.wangsr.chat.model.JoinLogPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;


@Repository
public interface JoinLogRepository extends JpaRepository<JoinLogPO,Long>, QuerydslPredicateExecutor<JoinLogPO> {
}