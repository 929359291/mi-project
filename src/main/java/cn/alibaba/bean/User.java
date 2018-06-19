package cn.alibaba.bean;

import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import lombok.Data;

/**
 * @author zengxc
 * @since 2018/6/19
 */
@Data
@TableName(value = "user")
public class User{

    @TableId
    @TableField(value = "id")
    private Integer id;
    @TableField(value = "name")
    private String name;
    @TableField(value = "age")
    private Integer age;
}
