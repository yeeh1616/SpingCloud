package com.example.bookservice.dao.dao;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bookservice.dao.BookDao;
import com.example.bookservice.domain.Book;
import org.apache.logging.log4j.util.Strings;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookDaoTestCase {
    @Autowired
    private BookDao bookDao;

    @Test
    void testGetById(){
//        System.out.println(bookDao.getById(0));//mybatis
        System.out.println(bookDao.selectById(0));//mybatis-plus
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("bbb");
        book.setType("bbb");
        book.setDescritpion("bbb");

        bookDao.insert(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(1);
        book.setName("ccc");
        book.setType("bbb");
        book.setDescritpion("bbb");

        bookDao.updateById(book);
    }

    @Test
    void testGetPage(){
        IPage page = new Page(0, 5);
        bookDao.selectPage(page, null);
        System.out.println(page.getPages());
        System.out.println(page.getSize());
        System.out.println(page.getSize());
        System.out.println(page.getRecords());
    }

    @Test
    void testGetBy(){
        QueryWrapper<Book> qw = new QueryWrapper<>();
        qw.like("name", "c");
        bookDao.selectList(qw);
    }

    @Test
    void testGetBy2(){
        // 报错，好像是版本的问题
        String name = "c";
        LambdaQueryWrapper<Book> lqw = new LambdaQueryWrapper<>();
        lqw.like(Strings.isNotEmpty(name), Book::getName, name);
        bookDao.selectList(lqw);
//        bookDao.selectList(null);
    }
}
