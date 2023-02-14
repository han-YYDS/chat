package cn.wangsr.chat.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author wjl
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResponseData<T> implements Serializable {
    private String requestId;
    private Integer code; // 200成功,400失败
    private String message;
    private String path;
    private T data; // T表示泛型,不同的实体通过response函数进行包装结果

    public static ResponseData ofSuccess(String message,Object data){
        return ResponseData.builder().code(200).message(message).data(data).build();
    }
    public static ResponseData ofFailed(String message,Object data){
        return ResponseData.builder().code(400).message(message).data(data).build();
    }

}
