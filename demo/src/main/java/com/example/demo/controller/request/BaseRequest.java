package com.example.demo.controller.request;

import lombok.Data;

@Data
public class BaseRequest {
    private int pageNum=1;
    private int pageSize=10;
}
