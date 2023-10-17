package com.example.demo.entity;

import lombok.Data;

import java.util.List;

@Data
public class Book {
    private String id;
    private String name;
    private String description;
    private String author;
    private String publisher;
    private String category;
    private List<String> categories;
}
