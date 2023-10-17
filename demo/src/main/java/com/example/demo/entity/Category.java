package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Category {
    private String id;
    private String name;
    private String remark;
    private String pid;

    private List<Category> children;

}
