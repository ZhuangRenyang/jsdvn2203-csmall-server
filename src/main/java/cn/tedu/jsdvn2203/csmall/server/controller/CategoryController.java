package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
@Slf4j
@RestController
@RequestMapping("/category")
public class CategoryController {

    public CategoryController(){
        log.info("创建控制器对象.CategoryController");
    }

     //访问路径http://localhost:8080/category/delete?id=123&...
    @RequestMapping("/{id:[0-9]+}/delete")
    public String delete(@PathVariable("id") Long id){
        log.info("id:{}",id);
        log.info("CategoryController.delete");
        return "del";
    }

//    @RequestMapping("/{name:[a-zA-z]+}/delete")
//    public String delete(@PathVariable("name") String name){
//        System.out.println("id:"+name);
//        System.out.println("CategoryController.delete");
//        return "del,name";
//    }

    //访问路径 http://localhost:8080/categories/add-new
//    @RequestMapping(value = "/add-new",method = RequestMethod.POST)
//    @RequestMapping({"/add-new"})
//    @RequestMapping(value = {"/add-new"})
//    @RequestMapping(value = "/add-new")
    @RequestMapping("/add-new")
    public String addNew(CategoryAddNewDTO categoryAddNewDTO){
        log.info("categoryAddNewDTO:{}",categoryAddNewDTO);
        log.info("CategoryController.add-new");
        return "add-new";
    }
    @RequestMapping("/{id}/update")
    public String update(@PathVariable("id") CategoryAddNewDTO categoryAddNewDTO){
        log.info("categoryAddNewDTO:{}",categoryAddNewDTO);
        log.info("CategoryController.update");
        return "update";
    }
    //访问路径 http://localhost:8080/category
    // @RequestMapping("/list")
    // @RequestMapping("")
    @RequestMapping("")
    public String list(){
        log.info("CategoryController.list");
        return "list";
    }
}
