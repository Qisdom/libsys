package com.example.demo.controller.request;

import lombok.Data;

@Data
public class AdminPageRequest extends BaseRequest {
    private String id;
    private String name;
    private String telephone;

}
