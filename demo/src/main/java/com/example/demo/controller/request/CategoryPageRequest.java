package com.example.demo.controller.request;

import lombok.Data;

@Data
public class CategoryPageRequest extends BaseRequest {
    private String name;
    private String id;
    private String pid;

}
