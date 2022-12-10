package com.example.bookservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.bookservice.controller.utils.R;
import com.example.bookservice.domain.Book;
import com.example.bookservice.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    public IBookService bookService;

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, bookService.getById(id));
    }

    @GetMapping
    public R getAll(){
        return new R(true, bookService.list());
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        IPage page = bookService.getPage(currentPage, pageSize);
        if(currentPage > page.getPages()){
            page = bookService.getPage((int)page.getPages(), pageSize);
        }
        return new R(true, page);
    }

    @PostMapping
    public R save(@RequestBody Book book){
        return new R(bookService.save(book));
    }

    @PutMapping
    public R update(@RequestBody Book book){
        return new R(bookService.modify(book));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(bookService.delete(id));
    }

}
