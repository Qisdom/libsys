package com.example.demo.service;

import com.example.demo.controller.request.BaseRequest;
import com.example.demo.entity.Borrow;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBorrowService {
    List<Borrow> list();

    PageInfo <Borrow> page(BaseRequest baseRequest);

    void save(Borrow borrow);

    Borrow getById(String id);

    void update(String id);

    void deleteById(String id);

    void edit(Borrow borrow);
}
