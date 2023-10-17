package com.example.demo.service;

import com.example.demo.controller.request.BaseRequest;
import com.example.demo.entity.User;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IUserService {
    List<User> list();

    PageInfo <User> page(BaseRequest baseRequest);

    void save(User user);

    User getById(String id);

    void update(User user);

    void deleteById(String id);
}
