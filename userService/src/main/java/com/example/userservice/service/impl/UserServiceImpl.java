package com.example.userservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.userservice.dao.UserDao;
import com.example.userservice.domain.User;
import com.example.userservice.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserDao, User> implements IUserService {
    @Autowired
    UserDao userDao;

    @Override
    public Boolean saveBook(User user) {
        return userDao.insert(user) > 0;
    }

    @Override
    public Boolean modify(User user) {
        return userDao.updateById(user) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return userDao.deleteById(id) > 0;
    }

    @Override
    public IPage<User> getPage(Integer currentPage, Integer pageSize) {
        IPage<User> page = new Page<>(currentPage, pageSize);
        userDao.selectPage(page, null);
        return page;
    }
}
