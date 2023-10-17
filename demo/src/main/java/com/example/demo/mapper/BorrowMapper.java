package com.example.demo.mapper;

import com.example.demo.controller.request.BaseRequest;
import com.example.demo.entity.Borrow;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface BorrowMapper {

    List<Borrow> list();

    List<Borrow> listByCondition(BaseRequest baseRequest);

    void save(Borrow borrow);

    Borrow getById(String id);

    void updateById(String id);

    void deleteById(String id);

    void edit(Borrow borrow);
}
