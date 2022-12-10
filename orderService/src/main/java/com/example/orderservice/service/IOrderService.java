package com.example.orderservice.service;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.orderservice.domain.Order;

public interface IOrderService extends IService<Order> {
    Boolean saveBook(Order order);
    Boolean modify(Order order);
    Boolean delete(Integer id);
    Order getOrderById(Integer id);

    IPage<Order> getPage(Integer currentPage, Integer pageSize);
}
