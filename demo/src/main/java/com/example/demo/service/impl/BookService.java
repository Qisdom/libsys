package com.example.demo.service.impl;

import cn.hutool.core.collection.CollUtil;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.demo.controller.request.BaseRequest;
import com.example.demo.entity.Book;
import com.example.demo.mapper.BookMapper;
import com.example.demo.service.IBookService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BookService implements IBookService {
    @Autowired
    BookMapper bookMapper;
    @Override
    public List<Book> list() {
        return bookMapper.list();
    }

    @Override
    public PageInfo<Book> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Book> books = bookMapper.listByCondition(baseRequest);

        return new PageInfo<>(books);
    }

    @Override
    public void save(Book book) {
        book.setCategory(category(book.getCategories()));
        Date date=new Date();
        book.setId("b"+DateUtil.format(date,"yyyyMMdd")+ Math.abs(IdUtil.fastSimpleUUID().hashCode()));
        bookMapper.save(book);
    }

    @Override
    public Book getById(String id) {
        return bookMapper.getById(id);
    }

    @Override
    public void update(Book book) {
        book.setCategory(category(book.getCategories()));
        bookMapper.updateById(book);
    }

    @Override
    public void deleteById(String id) {
        bookMapper.deleteById(id);
    }

    private String category(List<String> categories){
        StringBuilder sb =new StringBuilder();
        if (CollUtil.isNotEmpty(categories)){
            categories.forEach(v -> sb.append(v).append(">"));
            return sb.substring(0,sb.lastIndexOf(">"));
        }
        return sb.toString();
    }
}
