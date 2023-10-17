package com.example.demo.mapper;

import com.example.demo.controller.request.BaseRequest;
import com.example.demo.controller.request.LoginRequest;
import com.example.demo.entity.Admin;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface AdminMapper {

    List<Admin> list();

    List<Admin> listByCondition(BaseRequest baseRequest);

    void save(Admin obj);

    Admin getById(String id);

    void updateById(Admin obj);

    void deleteById(String id);

    Admin getByNameAndPassword(LoginRequest loginRequest);

}
