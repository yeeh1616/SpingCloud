package com.example.userservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.userservice.domain.User;

public interface IUserService extends IService<User> {
    Boolean saveBook(User order);
    Boolean modify(User order);
    Boolean delete(Integer id);

    IPage<User> getPage(Integer currentPage, Integer pageSize);
}
