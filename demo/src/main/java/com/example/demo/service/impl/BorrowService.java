package com.example.demo.service.impl;

import cn.hutool.core.date.DateTime;
import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.demo.controller.request.BaseRequest;
import com.example.demo.entity.Borrow;
import com.example.demo.mapper.BorrowMapper;
import com.example.demo.service.IBorrowService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BorrowService implements IBorrowService {
    @Autowired
    BorrowMapper borrowMapper;
    @Override
    public List<Borrow> list() {
        return borrowMapper.list();
    }

    @Override
    public PageInfo<Borrow> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Borrow> borrows = borrowMapper.listByCondition(baseRequest);

        return new PageInfo<>(borrows);
    }

    @Override
    public void save(Borrow borrow) {
        Date date=new Date();
        borrow.setId(("bor"+DateUtil.format(date,"yyyyMMdd")+ Math.abs(IdUtil.fastSimpleUUID().hashCode())));
        borrowMapper.save(borrow);
    }

    @Override
    public Borrow getById(String id) {
        return borrowMapper.getById(id);
    }

    @Override
    public void update(String id) {
        borrowMapper.updateById(id);
    }

    @Override
    public void deleteById(String id) {
        borrowMapper.deleteById(id);
    }

    @Override
    public void edit(Borrow borrow) {
        borrowMapper.edit(borrow);
    }

}
