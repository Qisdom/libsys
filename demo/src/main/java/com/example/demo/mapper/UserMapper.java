package com.example.demo.mapper;

import com.example.demo.controller.request.BaseRequest;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface UserMapper {

    List<User> list();

    List<User> listByCondition(BaseRequest baseRequest);

    void save(User user);

    User getById(String id);

    void updateById(User user);

    void deleteById(String id);
}
