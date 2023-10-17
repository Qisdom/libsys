package com.example.demo.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.demo.controller.request.BaseRequest;
import com.example.demo.entity.Category;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.service.ICategoryService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class CategoryService implements ICategoryService {
    @Autowired
    CategoryMapper categoryMapper;
    @Override
    public List<Category> list() {
        return categoryMapper.list();
    }

    @Override
    public PageInfo<Category> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Category> categories = categoryMapper.listByCondition(baseRequest);
        return new PageInfo<>(categories);
    }

    @Override
    public PageInfo<Category> search(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Category> categories = categoryMapper.listByCondition2(baseRequest);
        return new PageInfo<>(categories);
    }

    @Override
    public void save(Category obj) {
        Date date=new Date();
        obj.setId("c"+DateUtil.format(date,"yyyyMMdd")+ Math.abs(IdUtil.fastSimpleUUID().hashCode()));
        categoryMapper.save(obj);
    }

    @Override
    public Category getById(String id) {
        return categoryMapper.getById(id);
    }

    @Override
    public void update(Category category) {
        categoryMapper.updateById(category);
    }

    @Override
    public void deleteById(String id) {
        categoryMapper.deleteById(id);
    }

    @Override
    public List<Category> list1() {
        return categoryMapper.list1();
    }
}
