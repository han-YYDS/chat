package cn.wangsr.chat.model.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 单条会议记录
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HistoryChatDTO {
    private Long id; // 代表一次log
    private String creatorName;
    private String creatorId; // 创建者的ID
    private int roomId;
    private LocalDateTime createTime;
    private String participator; // 与会者 例如 ,3,1,3, 通过逗号连接,开头末尾都有
    private int isAlive; // 判断会议是否alive, 存活为1, 消亡为0
}


