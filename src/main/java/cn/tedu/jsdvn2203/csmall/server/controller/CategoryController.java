package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/category")
public class CategoryController {

    public CategoryController(){
        System.out.println("创建控制器对象.CategoryController");
    }

     //访问路径http://localhost:8080/category/delete?id=123&...
    @RequestMapping("/{id:[0-9]+}/delete")
    public String delete(@PathVariable("id") Long id){
        System.out.println("id:"+id);
        System.out.println("CategoryController.delete");
        return "del";
    }

//    @RequestMapping("/{name:[a-zA-z]+}/delete")
//    public String delete(@PathVariable("name") String name){
//        System.out.println("id:"+name);
//        System.out.println("CategoryController.delete");
//        return "del,name";
//    }

    //访问路径http://localhost:8080/category/add-new
//    @RequestMapping(value = "/add-new",method = RequestMethod.POST)
//    @RequestMapping({"/add-new"})
//    @RequestMapping(value = {"/add-new"})
//    @RequestMapping(value = "/add-new")
    @RequestMapping("/add-new")
    public String addNew(CategoryAddNewDTO categoryAddNewDTO){
        System.out.println("categoryAddNewDTO:"+categoryAddNewDTO);
        System.out.println("CategoryController.add-new");
        return "add-new";
    }
    @RequestMapping("/{id}/update")
    public String update(@PathVariable("id") CategoryAddNewDTO categoryAddNewDTO){
        System.out.println("categoryAddNewDTO:"+categoryAddNewDTO);
        System.out.println("CategoryController.update");
        return "update";
    }
    //访问路径http://localhost:8080/category
    @RequestMapping("")
    public String list(){
        System.out.println("CategoryController.list");
        return "list";
    }
}
