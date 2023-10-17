package com.example.demo.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Borrow {
    private String id;
    private String bid;
    private String uid;
    private String bname;
    private String uname;
    private String returned;
    private Date createtime;
    private Date updatetime;
}
