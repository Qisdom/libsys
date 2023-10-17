package com.example.demo.service;

import com.example.demo.controller.request.BaseRequest;
import com.example.demo.entity.Category;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface ICategoryService {
    List<Category> list();

    PageInfo<Category> page(BaseRequest baseRequest);

    PageInfo<Category> search(BaseRequest baseRequest);

    void save(Category obj);

    Category getById(String id);

    void update(Category obj);

    void deleteById(String id);


    List<Category> list1();
}
