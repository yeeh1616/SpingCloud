package com.example.orderservice.controller;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.example.orderservice.controller.utils.R;
import com.example.orderservice.domain.Order;
import com.example.orderservice.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/orders")
public class OrderController {

    @Autowired
    public IOrderService orderService;

    @GetMapping("{id}")
    public R getById(@PathVariable Integer id){
        return new R(true, orderService.getOrderById(id));
    }

    @GetMapping
    public R getAll(){
        return new R(true, orderService.list());
    }

    @GetMapping("{currentPage}/{pageSize}")
    public R getPage(@PathVariable Integer currentPage, @PathVariable Integer pageSize){
        IPage page = orderService.getPage(currentPage, pageSize);
        if(currentPage > page.getPages()){
            page = orderService.getPage((int)page.getPages(), pageSize);
        }
        return new R(true, page);
    }

    @PostMapping
    public R save(@RequestBody Order order){
        return new R(orderService.save(order));
    }

    @PutMapping
    public R update(@RequestBody Order order){
        return new R(orderService.modify(order));
    }

    @DeleteMapping("{id}")
    public R delete(@PathVariable Integer id){
        return new R(orderService.delete(id));
    }

}
