package com.example.demo.mapper;

import com.example.demo.controller.request.BaseRequest;
import com.example.demo.entity.Category;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface CategoryMapper {
    List<Category> list();

    List<Category> listByCondition(BaseRequest baseRequest);

    List<Category> listByCondition2(BaseRequest baseRequest);

    void save(Category obj);

    Category getById(String id);

    void updateById(Category obj);

    void deleteById(String id);

    List<Category> list1();
}
