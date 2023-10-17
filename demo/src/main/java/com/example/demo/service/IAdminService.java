package com.example.demo.service;

import com.example.demo.controller.dto.LoginDTO;
import com.example.demo.controller.request.BaseRequest;
import com.example.demo.controller.request.LoginRequest;
import com.example.demo.entity.Admin;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IAdminService {
    List<Admin> list();

    PageInfo <Admin> page(BaseRequest baseRequest);

    void save(Admin obj);

    Admin getById(String id);

    void update(Admin obj);

    void deleteById(String id);

    LoginDTO login(LoginRequest loginRequest);
}
