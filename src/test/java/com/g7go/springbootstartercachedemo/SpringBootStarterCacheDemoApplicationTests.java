package com.g7go.springbootstartercachedemo;

import com.g7go.springbootstartercachedemo.demo.pojo.User;
import com.g7go.springbootstartercachedemo.demo.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.test.context.junit4.SpringRunner;

import javax.annotation.Resource;

@EnableCaching
@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringBootStarterCacheDemoApplicationTests {

    @Resource
    private UserService userService;

    @Test
    public void saveUserTest() {
        userService.saveUser(new User("id1", "赵六", "衡水", "123456", 22));
    }

    @Test
    public void findUserTest() {
        for (int i = 0; i < 3; i++) {
            System.out.println("第" + i + "次");
            User user = userService.findUser();
            System.out.println(user);
        }
    }

    @Test
    public void updateUserTest() {
        userService.updateUser();
        User user = userService.findUser();
        System.out.println(user);
    }

    @Test
    public void clearUserTest() {
        userService.clearUser();
        User user = userService.findUser();
        System.out.println(user);
    }

}
