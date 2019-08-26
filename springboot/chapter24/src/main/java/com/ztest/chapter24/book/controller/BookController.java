package com.ztest.chapter24.book.controller;

import com.ztest.chapter24.book.bean.BookBean;
import com.ztest.chapter24.book.jpa.BookJPA;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * \* Created with IntelliJ IDEA.
 * \* @author: 11568
 * \* @date: 2019/08/26
 * \* Time: 17:34
 * \* 码云: https://gitee.com/SXQZ/springboot
 * \* To change this template use File | Settings | File Templates.
 * \* Description:
 * \
 */
@RestController
@RequestMapping(value = "/book")
public class BookController {

    @Autowired
    private BookJPA bookJPA;

    /**
     * 查询书籍列表
     * @return
     */
    @RequestMapping(value = "/list")
    public List<BookBean> list(){
        return bookJPA.findAll();
    }
}
