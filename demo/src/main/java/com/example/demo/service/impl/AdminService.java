package com.example.demo.service.impl;

import cn.hutool.core.date.DateUtil;
import cn.hutool.core.util.IdUtil;
import com.example.demo.controller.dto.LoginDTO;
import com.example.demo.controller.request.BaseRequest;
import com.example.demo.controller.request.LoginRequest;
import com.example.demo.entity.Admin;
import com.example.demo.exception.ServiceException;
import com.example.demo.mapper.AdminMapper;
import com.example.demo.service.IAdminService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class AdminService implements IAdminService {
    @Autowired
    AdminMapper adminMapper;
    @Override
    public List<Admin> list() {
        return adminMapper.list();
    }

    @Override
    public PageInfo<Admin> page(BaseRequest baseRequest) {
        PageHelper.startPage(baseRequest.getPageNum(),baseRequest.getPageSize());
        List<Admin> admins = adminMapper.listByCondition(baseRequest);

        return new PageInfo<>(admins);
    }

    @Override
    public void save(Admin obj) {
        Date date=new Date();
        obj.setId("a"+DateUtil.format(date,"yyyyMMdd")+ Math.abs(IdUtil.fastSimpleUUID().hashCode()));
        adminMapper.save(obj);
    }

    @Override
    public Admin getById(String id) {
        return adminMapper.getById(id);
    }

    @Override
    public void update(Admin admin) {
        adminMapper.updateById(admin);
    }

    @Override
    public void deleteById(String id) {
        adminMapper.deleteById(id);
    }

    @Override
    public LoginDTO login(LoginRequest loginRequest) {
        Admin admin = adminMapper.getByNameAndPassword(loginRequest);
        if (admin==null){
            throw new ServiceException("用户名或密码错误");
        }
        LoginDTO loginDTO = new LoginDTO();
        BeanUtils.copyProperties(admin,loginDTO);
        return loginDTO;
    }
}
