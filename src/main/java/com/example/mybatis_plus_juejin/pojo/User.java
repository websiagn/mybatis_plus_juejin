package com.example.mybatis_plus_juejin.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@TableName("user")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
//    @TableId(type = IdType.AUTO) // 注解生成主键策略,开启自增需要与数据库自增搭配
    private Long id;
    private String name;
    private Integer age;
    private String email;

    @Version
    private Integer version;

    @TableLogic
    private Integer deleted;

    @TableField(fill = FieldFill.INSERT) // 配置默认值
    private Date createTime;

    @TableField(fill = FieldFill.INSERT_UPDATE) // 配置默认值
    private Date updateTime;
}
