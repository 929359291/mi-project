package cn.alibaba.service;

import cn.alibaba.bean.User;
import cn.alibaba.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zengxc
 * @since 2018/6/19
 */
@Service
public class UserService {

    @Autowired
    UserMapper userMapper;

    public List<User> getUserList(){
        List<User> userList = userMapper.getUserList();
        return userList;
    }

    public int deleteUserByGreaterThan20(){
        return userMapper.deleteUserByGreaterThan20();
    }

    public List<Integer> addUserRandom100() {
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            User user = new User();
            user.setAge(i);
            user.setName("姓名" + i);
            int count = userMapper.insertList(user);
            list.add(count);
        }
        return list;
    }
}
