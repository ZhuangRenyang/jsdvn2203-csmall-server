package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryDeleteDTO;
import cn.tedu.jsdvn2203.csmall.server.service.ICategoryService;
import cn.tedu.jsdvn2203.csmall.server.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Slf4j
@Api(tags ="1.类别管理模块")
@RestController
@RequestMapping("/categories")
public class CategoryController {

@Autowired
private ICategoryService categoryService;

    public CategoryController(){
        log.info("创建控制器对象.CategoryController");
    }

    //访问路径 http://localhost:8080/categories/add-new
//    @RequestMapping(value = "/add-new",method = RequestMethod.POST)
//    @RequestMapping({"/add-new"})
//    @RequestMapping(value = {"/add-new"})
//    @RequestMapping(value = "/add-new")
    @ApiOperation("添加类别")
    @ApiOperationSupport(order = 10)
    @PostMapping("/add-new")
    public JsonResult addNew(@RequestBody @Valid CategoryAddNewDTO categoryAddNewDTO){
        log.info("接收到添加类别的请求,参数:{}",categoryAddNewDTO);
            categoryService.addNew(categoryAddNewDTO);
        return JsonResult.ok();
    }

     //访问路径 http://localhost:8080/category/delete?id=123&...
     //    @RequestMapping("/{name:[a-zA-z]+}/delete")
//    public String delete(@PathVariable("name") String name){
//        System.out.println("id:"+name);
//        System.out.println("CategoryController.delete");
//        return "del,name";
//    }
     @ApiOperation("根据id删除类别")
     @ApiOperationSupport(order = 20)
    @PostMapping("/delete")
    public String delete(CategoryDeleteDTO categoryDeleteDTO){

        log.info("id:{}",categoryDeleteDTO.getId());
            categoryService.delete(categoryDeleteDTO);
        return "del";
    }

    @ApiOperation("修改类别")
    @ApiOperationSupport(order = 30)
    @PostMapping("/{id}/update")
    public String update(@PathVariable("id") CategoryAddNewDTO categoryAddNewDTO){
        log.info("categoryAddNewDTO:{}",categoryAddNewDTO);
        log.info("CategoryController.update");
        return "update";
    }
    //访问路径 http://localhost:8080/category
    // @RequestMapping("/list")
    // @RequestMapping("")
    @ApiOperation("查询类别列表")
    @ApiOperationSupport(order = 40)
    @GetMapping("")
    public String list(){
        log.info("CategoryController.list");
        return "list";
    }
}
