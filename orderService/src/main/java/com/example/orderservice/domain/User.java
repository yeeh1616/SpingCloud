package com.example.orderservice.domain;

import lombok.Data;

@Data
public class User {
    private Integer id;
    private String type;
    private String name;
    private String description;
}
