package com.example.bookservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.bookservice.domain.Book;

public interface IBookService extends IService<Book> {
    Boolean saveBook(Book book);
    Boolean modify(Book book);
    Boolean delete(Integer id);

    IPage<Book> getPage(Integer currentPage, Integer pageSize);
}
