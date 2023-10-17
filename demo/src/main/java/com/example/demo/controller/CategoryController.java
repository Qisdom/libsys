package com.example.demo.controller;

import cn.hutool.core.collection.CollUtil;
import com.example.demo.common.Result;
import com.example.demo.controller.request.CategoryPageRequest;
import com.example.demo.entity.Book;
import com.example.demo.entity.Category;
import com.example.demo.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@CrossOrigin
@RestController
@RequestMapping("/category")
public class CategoryController {
    @Autowired
    ICategoryService iCategoryService;

    @PostMapping("/add_save")
    public Result save(@RequestBody Category obj){
        iCategoryService.save(obj);
        return Result.success();
    }

    @PutMapping("/update")
    public Result update(@RequestBody Category obj){
        iCategoryService.update(obj);
        return Result.success();
    }

    @DeleteMapping("/delete/{id}")
    public Result delete(@PathVariable String id){
        iCategoryService.deleteById(id);
        return Result.success();
    }

    @GetMapping("/{id}")
    public Result getById(@PathVariable String id){
        Category category= iCategoryService.getById(id);
        return Result.success(category);
    }

    @GetMapping("/list")
    public Result list() {
        List<Category> categorise=iCategoryService.list();
        return Result.success(categorise);
    }

    @GetMapping("/list1")
    public Result list1() {
        List<Category> categorise=iCategoryService.list1();
        return Result.success(categorise);
    }

    @GetMapping("/page")
    public Result page(CategoryPageRequest categoryPageRequest) {
        return Result.success(iCategoryService.page(categoryPageRequest));
    }

    @GetMapping("/search")
    public Result search(CategoryPageRequest categoryPageRequest) {
        return Result.success(iCategoryService.search(categoryPageRequest));
    }

    @GetMapping("/tree")
    public Result tree(){
        List<Category> list = iCategoryService.list();
        //第一层
        List<Category> treeList =list.stream().filter(v -> v.getPid() == null).collect(Collectors.toList());
        return Result.success(createTree(null,list));//从第一级开始递归
    }
    private List<Category> createTree(String pid, List<Category> categories) {
        List<Category> treeList = new ArrayList<>();
        for (Category category : categories) {
            if(pid==null) {
                if(category.getPid()==null){
                    //此时为第一节点
                    treeList.add(category);
                    category.setChildren(createTree(category.getId(), categories));
                }
            }else{
                //此时为非第一节点也非叶子节点的节点
                if (pid.equals(category.getPid()) ) {
                    treeList.add(category);
                    category.setChildren(createTree(category.getId(), categories));
                }
                //此时为叶子节点
                if(CollUtil.isEmpty(category.getChildren())){
                    category.setChildren(null);
                }
            }
        }
        return treeList;
    }
}
