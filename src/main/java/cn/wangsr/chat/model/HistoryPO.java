package cn.wangsr.chat.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@DynamicInsert
@DynamicUpdate
@Entity(name= HistoryPO.ENTITY_NAME)
// 创建者用户名  会议创建时间   roomID
public class HistoryPO implements Serializable {
    public static final String ENTITY_NAME = "history";
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private int id;

    @Column(columnDefinition = "varchar(100) COMMENT '创建者用户名'")
    private String creatorName;

    @Column(columnDefinition = "int(20) COMMENT '创建者Id'")
    private Long creatorId;

    @Column(columnDefinition = "varchar(255) COMMENT '与会人员Ids（按逗号,隔开）'")
    private String participators;

    @Column(columnDefinition = "int(20) COMMENT '会议Id'")
    private int roomId;

    @Column(columnDefinition = "int(20) COMMENT '会议状态: 0-消亡, 1-存活'")
    private int isAlive;


    @CreationTimestamp
    private LocalDateTime createTime;
}

