package com.example.demo.controller.request;

import lombok.Data;

@Data
public class BorrowPageRequest extends BaseRequest {
    private String id;
    private String uname;
    private String bname;
    private String returned;
}
