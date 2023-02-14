// 增加
import request from "./request";
export function rulesInsert(param) {
    return request({
        url: "/user/saveInfo",
        method: "post",
        headers: {
            "Content-Type": "application/json" // 如果写成contentType会报错
        },
        data: param
    });
}