package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.controller.request.BorrowPageRequest;
import com.example.demo.entity.Borrow;
import com.example.demo.service.IBorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/borrow")
public class BorrowController {
    @Autowired
    IBorrowService iBorrowService;

    @PostMapping("/add_save")
    public Result save(@RequestBody Borrow borrow){
        iBorrowService.save(borrow);
        return Result.success();
    }

    @PutMapping("/update/{id}")
    public Result update(@PathVariable String id){
        iBorrowService.update(id);
        return Result.success();
    }

    @PutMapping("/edit")
    public Result edit(@RequestBody Borrow borrow){
        iBorrowService.edit(borrow);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id){
        iBorrowService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable String id){
        Borrow borrow= iBorrowService.getById(id);
        return Result.success(borrow);
    }

    @GetMapping("/list")
    public Result list() {
        List<Borrow> borrows=iBorrowService.list();
        return Result.success(borrows);
    }

    @GetMapping("/page")
    public Result page(BorrowPageRequest borrowPageRequest) {
        return Result.success(iBorrowService.page(borrowPageRequest));
    }
}
