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

/**
 * @author wjl
 * 数据表,以对象为数据结构存储
 */
@Data // lombok
@NoArgsConstructor // 无参构造
@AllArgsConstructor // 全参构造
@Builder // lombok 初始化赋值
@DynamicInsert
@DynamicUpdate
@Entity(name= UserFriendsPO.ENTITY_NAME) // 指定是一个实体bean
public class UserFriendsPO implements Serializable {
    public static final String ENTITY_NAME = "user_friends";
    private static final long serialVersionUID = 1L;
    @Id // 主键
    @GeneratedValue(strategy= GenerationType.IDENTITY) // 生成主键
    private Long id;
    // column定制字段属性
    @Column(columnDefinition = "varchar(100) COMMENT '好友备注'")
    private String noteName;
    @Column(columnDefinition = "int(20) COMMENT '用户Id'")
    private Long userId;
    @Column(columnDefinition = "int(20) COMMENT '好友Id'")
    private Long partnerId;
    @Column(columnDefinition = "int(10) COMMENT '1.待同意 2.已同意'")
    private Integer type;
    @Column(columnDefinition = "int(10) COMMENT '1.申请人 2.被申请人'")
    private Integer belong;
    @CreationTimestamp
    private LocalDateTime createTime;
    @UpdateTimestamp
    private LocalDateTime updateTime;




}
