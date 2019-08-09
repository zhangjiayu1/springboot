package com.ztest.chapter13.controller;

import com.ztest.chapter13.entity.User;
import com.ztest.chapter13.jpa.UserJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* User: 11568
 * \* Date: 2019/08/09
 * \* Time: 10:40
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:chapter 13 控制实现类
 * \
 */
@RestController
public class UserController {

    @Autowired
    private UserJPA userJPA;

    @RequestMapping(value = "/list")
    public List<User> list(){
        return userJPA.findAll();
    }

    @RequestMapping(value = "/add")
    public String add(){
        User user = new User();
        user.setTName("测试");
        user.setTAddress("测试地址");
        user.setTAge(21);
        userJPA.save(user);
        return "用户信息添加成功";
    }

    @RequestMapping(value = "/delete")
    public String delete(Long userId){
        userJPA.deleteById(userId);
        return "删除成功";
    }

    @RequestMapping(value = "/age")
    public List<User> ageList(){
        return userJPA.nativeQuery(20);
    }

    /**
     * 自定义删除
     * @return
     */
    @RequestMapping(value = "/deleteWhere")
    public String deleteWhere(){
        userJPA.deleteQuery("admin","123");
        return "自定义删除成功";
    }

    @RequestMapping(value = "/cutpage")
    public List<User> cutPage(int page){
        User user = new User();
        user.setSize(2);
        user.setSord("desc");
        user.setPage(page);

        //获取排序对象
        Sort.Direction sort_direction = Sort.Direction.ASC.toString().equalsIgnoreCase(user.getSord()) ? Sort.Direction.ASC :Sort.Direction.DESC;
        //设置排序对象参数
        Sort sort = new Sort(sort_direction,user.getSidx());
        //创建分页对象
        PageRequest pageRequest = new PageRequest(user.getPage() - 1,user.getSize(),sort);
        //执行分页查询
        return userJPA.findAll(pageRequest).getContent();
    }
}
