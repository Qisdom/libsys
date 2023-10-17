package com.example.demo.controller;

import com.example.demo.common.Result;
import com.example.demo.controller.request.BookPageRequest;
import com.example.demo.entity.Book;
import com.example.demo.service.IBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
@RequestMapping("/book")
public class BookController {
    @Autowired
    IBookService iBookService;

    @PostMapping("/add_save")
    public Result save(@RequestBody Book book){
        iBookService.save(book);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Book book){
        iBookService.update(book);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id){
        iBookService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable String id){
        Book book= iBookService.getById(id);
        return Result.success(book);
    }

    @GetMapping("/list")
    public Result list() {
        List<Book> books=iBookService.list();
        return Result.success(books);
    }

    @GetMapping("/page")
    public Result page(BookPageRequest bookPageRequest) {
        return Result.success(iBookService.page(bookPageRequest));
    }


}
