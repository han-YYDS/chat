package cn.wangsr.chat.controller;

import cn.wangsr.chat.annotation.IgnoreToken;
import cn.wangsr.chat.common.ResponseData;
import cn.wangsr.chat.model.UserInfoPO;
import cn.wangsr.chat.model.dto.UserSuccessDTO;
import cn.wangsr.chat.service.UserServiceImpl;
import cn.wangsr.chat.util.JwtUtils;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@RestController // 定义为返回json的controller
public class UserController {
    @Resource
    UserServiceImpl userService;

    @PostMapping("/register") // 定义一个post接口
    @IgnoreToken
    // RequestBody: 将现在传入的json转换为java对象实体,这里的实体就是 PO类,将其插入到数据库
    public ResponseData register(@RequestBody UserInfoPO userInfoPO, HttpServletResponse response){
        return userService.register(userInfoPO);
    }

    @PostMapping("/login") // http://IP:8006/login
    @IgnoreToken
    public ResponseData login(@RequestParam String username, @RequestParam String password, HttpServletResponse response){
        UserSuccessDTO login = userService.login(username, password); // 调用JPA函数
        response.setHeader(JwtUtils.AUTH_HEADER_KEY,login.getToken());
        // return code,sid
        return ResponseData.ofSuccess("登录成功",login);
    }

    @GetMapping("/loadMessages") //
    public ResponseData loadMessages(@RequestParam Long userId,@RequestParam Long targetId,@RequestParam Integer type){
        return ResponseData.ofSuccess("success",userService.loadUserMessageByBindTargetId(userId, targetId, type));
    }

    @GetMapping("/loadUserFriendsPage")
    public ResponseData loadUserFriendsPage(Long userId){
       return ResponseData.ofSuccess("success",userService.loadUserFriendsPage(userId));
    }

    @GetMapping("/searchUser")
    public ResponseData searchUser(Long userId,String username){
        return ResponseData.ofSuccess("success",userService.searchUser(userId, username));
    }

    @PostMapping("/applyAddFriends")
    public ResponseData applyAddFriends(@RequestParam Long userId,@RequestParam Long targetId,@RequestParam(required = false) String noteName){
        userService.applyAddFriends(userId, targetId, noteName);
        return ResponseData.ofSuccess("申请成功",null);
    }

    @PostMapping("/acceptFriendsApply")
    public ResponseData acceptFriendsApply(@RequestParam Long userId,@RequestParam Long targetId,@RequestParam(required = false) String noteName){
        userService.acceptFriendsApply(userId, targetId, noteName);
        return ResponseData.ofSuccess("success",null);
    }

//    // TODO
//    @PostMapping("/acceptGroupApply")
//    public ResponseData acceptGroupApply(@RequestParam Long userId,@RequestParam Long targetId,@RequestParam(required = false) String noteName){
//        userService.acceptFriendsApply(userId, targetId, noteName);
//        return ResponseData.ofSuccess("success",null);
//    }
//
//    // TODO
//    @PostMapping("/applyAddGroup")
//    public ResponseData applyAddGroup(@RequestParam Long userId,@RequestParam Long targetId,@RequestParam(required = false) String noteName){
//        userService.acceptFriendsApply(userId, targetId, noteName);
//
//        return ResponseData.ofSuccess("success",null);
//    }

    @PostMapping("/createGroup")
    public ResponseData createGroup(@RequestBody Map<String,Object> params){
        return userService.createGroup(params);
    }



    @GetMapping("/loadReceivingFriends")
    public ResponseData loadReceivingFriends(Long userId){
        return ResponseData.ofSuccess("success",userService.loadReceivingFriends(userId));
    }

    @GetMapping("/loadGroupUserInfo")
    public ResponseData loadGroupUserInfo(Long groupId){
        return ResponseData.ofSuccess("success",userService.loadGroupUserInfo(groupId));
    }


    /**
     * 创建房间
     *  1. 插入历史会议条目
     *  2. 返回会议号
     * @param
     * @return
     */
    @GetMapping("/createRoom")
    @IgnoreToken
    public ResponseData createRoom(@RequestParam(value = "userId") String userId){
        // 获取满足要求的房间号

        Long roomId = userService.createRoomId();

        // 插入history
        Long luserId = Long.parseLong(userId);
        userService.insertHistory(luserId,(long)724173);

        return ResponseData.ofSuccess("success",roomId);
    }

    /**
     *  参加会议
     *      需要对history表中的participators增加用户
     * @param params
     * @return
     */
    @PostMapping("/joinRoom")
    @IgnoreToken
    public ResponseData joinRoom(@RequestBody Map<String,Object> params){
        return userService.joinRoom(params);
    }

    /**
     * 加载历史会议, 对参与过的会议进行展示
     * @param params
     * @return
     */
    @GetMapping("/history")
    // 创建房间,返回房间号
    public ResponseData loadHistory(@RequestBody Map<String,Object> params){
        return ResponseData.ofSuccess("success",userService.loadHistory(params));
    }


}
