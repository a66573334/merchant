package com.software.controller;

import com.alibaba.fastjson.JSONObject;
import com.software.domain.User;
import com.software.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.Map;

/**
 * Created by hasee on 2017/11/6.
 */

@Controller
@RequestMapping("/user")
public class UserController {
    /**
     * 日志（slf4j->logback）
     */
    private static final Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private UserService userService;


    @GetMapping("/welcome")
    public String welcome(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "Welcome");
        return "welcome";
    }

    @GetMapping("/login")
    public String login(Map<String, Object> model) {
        model.put("time", new Date());
        model.put("message", "Welcome");
        return "index";
    }
    /**
     * 返回text格式数据
     *
     * @param id 主键id
     * @return 用户json字符串
     */
    @RequestMapping("/get/id/{id}")
    @ResponseBody
    public String getUserById(@PathVariable("id") String id) {
        logger.info("request /user/get/id/{id}, parameter is " + id);
        User user = userService.findById(Integer.parseInt(id));
        return JSONObject.toJSONString(user);
    }

    @RequestMapping("/get/username/{username}")
    @ResponseBody
    public String getUserByUsername(@PathVariable("username") String username) {
        logger.info("request /get/username/{username}, parameter is " + username);
        User user = userService.findByUsername(username);
        return JSONObject.toJSONString(user);
    }

    @RequestMapping("/add/{password}/{username}")
    @ResponseBody
    public String addUser(@PathVariable("password") String password, @PathVariable("username") String username, boolean throwEx) {
        User user = new User();
        user.setPassword(password);
        user.setUsername(username);
        int id = -1;
        try {
            id = userService.addUser(user, throwEx);
        } catch (RuntimeException ex) {
            System.out.println(ex.getMessage());
        }
        return String.valueOf(id);
    }

    @RequestMapping("/delete/{id}")
    @ResponseBody
    public void deleteUserById(@PathVariable("id") int id) {
        this.userService.deleteUserById(id);
    }

    @RequestMapping("/update/{id}/{password}/{username}")
    @ResponseBody
    public User updateUser(@PathVariable("id") int id, @PathVariable("password") String password, @PathVariable("username") String username) {
        User user = new User();
        user.setId(id);
        user.setPassword(password);
        user.setUsername(username);
        return userService.updateUser(user);
    }

    @RequestMapping("/norollback")
    public User noRollback(User user) {
        return userService.saveUserWithoutRollBack(user);
    }

    @RequestMapping("/rollback")
    public User rollback(User user) {
        return userService.saveUserWithRollBack(user);
    }
}
