package cn.alibaba.controller;

import cn.alibaba.bean.User;
import cn.alibaba.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

/**
 * @author zengxc
 * @since 2018/6/19
 */
@RestController
@RequestMapping("/user")
public class UsersController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UsersController.class);

    @Autowired
    UserService userService;

    @GetMapping(value = "/query-list")
    public Object getUserList() {
        LOGGER.info("request come in api getUserList");
        List<User> userList = userService.getUserList();
        LOGGER.info("the request end");
        return userList;
    }

    @RequestMapping(value = "delete-user", method = RequestMethod.DELETE)
    public ResponseEntity deleteUser() {
        LOGGER.info("delete user request come in");
        try {
            int resultNum = userService.deleteUserByGreaterThan20();
            LOGGER.info(String.format("delete result is %s", resultNum));
            return ResponseEntity.status(HttpStatus.OK).body(resultNum);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            LOGGER.info("delete user request end");
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

    @PostMapping("/add-user")
    public ResponseEntity<String> addUsers() {
        LOGGER.info("add User request come in time:{}", Date.valueOf(LocalDate.now()));
        try {
            List<Integer> nums = userService.addUserRandom100();
            String desc = "add num resp = " + nums.size();
            return ResponseEntity.status(HttpStatus.OK).body(desc);
        } catch (Exception e){
            e.printStackTrace();
        }finally {
        }
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
    }

}
