package com.example.bookservice.dao.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.bookservice.domain.Book;
import com.example.bookservice.service.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BookServiceTestCase2 {
    @Autowired
    private BookService bookService;

    @Test
    void testGetById(){
        bookService.getById(1);
    }

    @Test
    void testSave(){
        Book book = new Book();
        book.setName("bbb");
        book.setType("bbb");
        book.setDescritpion("bbb");

        bookService.save(book);
    }

    @Test
    void testUpdate(){
        Book book = new Book();
        book.setId(1);
        book.setName("ddd");
        book.setType("bbb");
        book.setDescritpion("bbb");

        bookService.update(book);
    }

    @Test
    void testGetPage(){
        IPage page = bookService.getPage(1, 5);
    }
}
