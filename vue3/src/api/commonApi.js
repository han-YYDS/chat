import request from "../util/http"

export function Login(data) {
    return request({
        url: '/login',
        method: 'post',
        params:data // 这里的data是对象,在这里会将url改写为对后端的访问,并携带data作为参数
    })
}

export function Register(data) {
    return request({
        url: '/register',
        method: 'post',
        data: data
    })
}

//加载消息记录
export function loadMessages(data) {
    return request({
        url:'/loadMessages',
        method: 'get',
        params: data
    })
}

//通讯录加载
export function loadUserFriendsPage(data) {
    return request({
        url:'/loadUserFriendsPage',
        method: 'get',
        params: data
    })
}
//搜索用户
export function searchUser(data) {
    return request({
        url:'/searchUser',
        method: 'get',
        params: data
    })
}
//添加好友
export function applyAddFriends(data) {
    return request({
        url:'/applyAddFriends',
        method: 'post',
        params: data
    })
}

//查询待处理好友申请
export function loadReceivingFriends(data) {
    return request({
        url:'/loadReceivingFriends',
        method: 'get',
        params: data
    })
}
//同意好友申请
export function acceptFriendsApply(data) {
    return request({
        url:'/acceptFriendsApply',
        method: 'post',
        params: data
    })
}

//获取群成员信息
export function loadGroupUserInfo(data) {
    return request({
        url:'/loadGroupUserInfo',
        method: 'get',
        params: data
    })
}

// //同意群聊申请
// export function acceptGroupApply(data) {
//     return request({
//         url:'/acceptGroupApply',
//         method: 'post',
//         data: data
//     })
// }

// //群聊邀请
// export function applyAddGroup(data) {
//     return request({
//         url:'/applyAddGroup',
//         method: 'post',
//         data: data
//     })
// }

//创建群聊
export function createGroup(data) {
    return request({
        url:'/createGroup',
        method: 'post',
        data: data
    })
}

/*
*   创建房间
*/ 
export function createRoom(data){
    return request({
        url: '/createRoom',
        method: 'get',
        data: data 
    })
}

/**
 * 加入房间
 * @param {*} data 
 * @returns 
 */
export function joinRoom(data){
    return request({
        url: '/joinRoom',
        method: "post",
        data: data 
    })
}

/**
 * 获取用户信息
 * @param {} data 
 * @returns 
 */
export function getUserInfo(data){
    return request({
        url: '/getUserInfo',
        method: 'post',
        data: data
    })
}