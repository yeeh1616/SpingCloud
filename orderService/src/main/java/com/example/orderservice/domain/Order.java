package com.example.orderservice.domain;

import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;

import java.beans.Transient;

@Data
public class Order {
    private Integer id;
    private String type;
    private String name;
    private String description;

    @TableField(exist = false)
    private User user;
}
