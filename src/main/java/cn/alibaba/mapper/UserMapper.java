package cn.alibaba.mapper;

import cn.alibaba.bean.User;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @author zengxc
 * @since 2018/6/19
 */
@Mapper
public interface UserMapper extends BaseMapper<User>{

    @Select("SELECT * FROM USER")
    List<User> getUserList();

    @Delete("DELETE FROM `user` WHERE `user`.id > 20")
    int deleteUserByGreaterThan20();

    @Insert("INSERT INTO `user` (`user`.id, `user`.name, `user`.age) VALUES (#{id}, #{name}, #{age})")
    int insertList(User user);
}
