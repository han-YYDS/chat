package cn.wangsr.chat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@Entity(name = JoinLogPO.ENTITY_NAME)
// 表中条目相当于一次键值对 <userId : historyId>
public class JoinLogPO implements Serializable {
    public static final String ENTITY_NAME = "joinLog";
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;

    @Column(columnDefinition = "int(20) COMMENT '参与者Id'")
    private Long joinerId;

    @Column(columnDefinition = "int(20) COMMENT '单次与会记录标识符'")
    private Long joinChat; // 是参与过的会单次议记录的标识(会议记录表的主键)

    @CreationTimestamp
    private LocalDateTime joinTime;
}


