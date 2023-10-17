package com.example.demo.controller.request;

import lombok.Data;

@Data
public class UserPageRequest extends BaseRequest {
    private String id;
    private String name;
    private String telephone;
    private String level;
}
