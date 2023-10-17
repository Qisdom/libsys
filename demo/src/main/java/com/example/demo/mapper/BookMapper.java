package com.example.demo.mapper;

import com.example.demo.controller.request.BaseRequest;
import com.example.demo.entity.Book;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BookMapper {

    List<Book> list();

    List<Book> listByCondition(BaseRequest baseRequest);

    void save(Book book);

    Book getById(String id);

    void updateById(Book book);

    void deleteById(String id);
}
