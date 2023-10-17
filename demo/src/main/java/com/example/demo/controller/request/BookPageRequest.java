package com.example.demo.controller.request;

import lombok.Data;

@Data
public class BookPageRequest extends BaseRequest {
    private String id;
    private String name;
    private String author;
    private String publisher;
    private String category;
}
