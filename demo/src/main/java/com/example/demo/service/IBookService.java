package com.example.demo.service;

import com.example.demo.controller.request.BaseRequest;
import com.example.demo.entity.Book;
import com.github.pagehelper.PageInfo;

import java.util.List;

public interface IBookService {
    List<Book> list();

    PageInfo <Book> page(BaseRequest baseRequest);

    void save(Book book);

    Book getById(String id);

    void update(Book book);

    void deleteById(String id);
}
