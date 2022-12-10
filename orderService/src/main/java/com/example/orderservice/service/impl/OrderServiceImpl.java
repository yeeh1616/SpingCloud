package com.example.orderservice.service.impl;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.orderservice.controller.utils.R;
import com.example.orderservice.dao.OrderDao;
import com.example.orderservice.domain.Order;
import com.example.orderservice.domain.User;
import com.example.orderservice.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class OrderServiceImpl extends ServiceImpl<OrderDao, Order> implements IOrderService {
    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RestTemplate restTemplate;

    @Override
    public Boolean saveBook(Order order) {
        return orderDao.insert(order) > 0;
    }

    @Override
    public Boolean modify(Order order) {
        return orderDao.updateById(order) > 0;
    }

    @Override
    public Boolean delete(Integer id) {
        return orderDao.deleteById(id) > 0;
    }

    @Override
    public Order getOrderById(Integer id) {
        Order order = orderDao.selectById(id);

        String url = "http://userservice/users/" + order.getId();
        R r = restTemplate.getForObject(url, R.class);
//        order.setUser(r);

        return order;
    }

    @Override
    public IPage<Order> getPage(Integer currentPage, Integer pageSize) {
        IPage<Order> page = new Page<>(currentPage, pageSize);
        orderDao.selectPage(page, null);
        return page;
    }
}
