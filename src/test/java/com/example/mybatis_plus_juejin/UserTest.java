package com.example.mybatis_plus_juejin;

import com.baomidou.mybatisplus.core.injector.methods.SelectById;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.mybatis_plus_juejin.mapper.UserMappser;
import com.example.mybatis_plus_juejin.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class UserTest {
    @Autowired
    private UserMappser userMappser;

    @Test
    public void TestSelect(){
        List<User> users = userMappser.selectList(null);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("saodh");
        user.setAge(33);
        user.setEmail("dsaod@qq.com");
        int result = userMappser.insert(user);
        System.out.println(result);
        System.out.println(user);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId((long) 7);
        user.setName("Java");
        int result = userMappser.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testOptimisticLocker01() {
        User user = userMappser.selectById(2);
        user.setName("修改后");
        int result = userMappser.updateById(user);
        if (result ==1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void testOptimisticLocker2() {
        User user = userMappser.selectById(2);
        user.setName("修改后");
        user.setVersion(user.getVersion()-1);//测试旧版本
        int result = userMappser.updateById(user);
        if (result == 1) {
            System.out.println("修改成功");
        } else {
            System.out.println("修改失败");
        }
    }

    @Test
    public void testSelectPage(){
        //构建分页条件第二页每页显示3条
        Page<User> page=new Page<>(2,3);
        //使用分页条件查询，不使用其他条件
        userMappser.selectPage(page, null);
        //获取分页后查询出的记录
        List<User> records = page.getRecords();
        records.forEach(System.out::println);
        System.out.println("是否有下一页："+page.hasNext());
        System.out.println("是否有上一页："+page.hasPrevious());
        System.out.println("总记录数："+page.getTotal());
    }

    @Test
    public void testLogicDelete() {
        int result = userMappser.deleteById(1);
        System.out.println(result);
    }

    @Test
    public void testSelectById(){
        User user = userMappser.selectById(1);
        System.out.println(user);
    }

    @Test
    public void testSelectBatchIds(){
        List<User> users = userMappser.selectBatchIds(Arrays.asList(1, 2, 3));
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void selectUserByMap() {
        Map<String,Object> param = new HashMap<>();
        param.put("name","java");
        param.put("age",11);
        List<User> users = userMappser.selectByMap(param);
        for (User user : users) {
            System.out.println(user);
        }
    }

    @Test
    public void testDeleteBatchIds() {
        int i = userMappser.deleteBatchIds(Arrays.asList(2, 3, 4));
        System.out.println(i);
    }
}
