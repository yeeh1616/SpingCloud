package com.example.userservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.userservice.controller.utils.R;
import com.example.userservice.domain.User;
import com.example.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    public IUserService userService;

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, userService.getById(id));
    }

    @GetMapping
    public R getAll(){
        return new R(true, userService.list());
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        IPage page = userService.getPage(currentPage, pageSize);
        if(currentPage > page.getPages()){
            page = userService.getPage((int)page.getPages(), pageSize);
        }
        return new R(true, page);
    }

    @PostMapping
    public R save(@RequestBody User user){
        return new R(userService.save(user));
    }

    @PutMapping
    public R update(@RequestBody User user){
        return new R(userService.modify(user));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(userService.delete(id));
    }

}
