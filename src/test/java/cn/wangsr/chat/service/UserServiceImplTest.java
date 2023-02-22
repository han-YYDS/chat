package cn.wangsr.chat.service;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

// service层测试

@SpringBootTest
class UserServiceImplTest {
    private  UserServiceImpl userService;
    @Test
    void createRoomId() {
        Long roomId = userService.createRoomId();

    }
}