package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.controller.dto.LoginDTO;
import com.example.demo.controller.request.AdminPageRequest;
import com.example.demo.controller.request.LoginRequest;
import com.example.demo.entity.Admin;
import com.example.demo.service.IAdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    IAdminService iAdminService;

    @PostMapping("/login")
    public Result login(@RequestBody LoginRequest loginRequest){
        LoginDTO loginDTO = iAdminService.login(loginRequest);
        return Result.success(loginDTO);
    }

    @PostMapping("/add_save")
    public Result save(@RequestBody Admin obj){
        iAdminService.save(obj);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Admin obj){
        iAdminService.update(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id){
        iAdminService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable String id){
        Admin admin= iAdminService.getById(id);
        return Result.success(admin);
    }

    @GetMapping("/list")
    public Result list() {
        List<Admin> admins=iAdminService.list();
        return Result.success(admins);
    }

    @GetMapping("/page")
    public Result page(AdminPageRequest adminPageRequest) {

        return Result.success(iAdminService.page(adminPageRequest));
    }
}
