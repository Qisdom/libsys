package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.controller.request.UserPageRequest;
import com.example.demo.entity.User;
import com.example.demo.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    IUserService iUserService;

    @PostMapping("/add_save")
    public Result save(@RequestBody User user){
        iUserService.save(user);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody User user){
        iUserService.update(user);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id){
        iUserService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable String id){
        User user= iUserService.getById(id);
        return Result.success(user);
    }

    @GetMapping("/list")
    public Result list() {
        List<User> users=iUserService.list();
        return Result.success(users);
    }

    @GetMapping("/page")
    public Result page(UserPageRequest userPageRequest) {
        return Result.success(iUserService.page(userPageRequest));
    }
}
