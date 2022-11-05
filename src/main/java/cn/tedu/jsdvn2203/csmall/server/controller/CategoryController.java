package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.ICategoryService;
import cn.tedu.jsdvn2203.csmall.server.web.JsonResult;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Slf4j
@Api(tags = "1.类别管理模块")
@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private ICategoryService categoryService;

    public CategoryController() {
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
    public JsonResult addNew(@RequestBody @Valid CategoryAddNewDTO categoryAddNewDTO) {
        log.info("接收到添加类别的请求,参数:{}", categoryAddNewDTO);
        categoryService.insert(categoryAddNewDTO);
        return JsonResult.ok();
    }

    //访问路径 http://localhost:8080/category/delete?id=123&...
    //    @RequestMapping("/{name:[a-zA-z]+}/delete")
//    public String delete(@PathVariable("name") String name){
//        System.out.println("id:"+name);
//        System.out.println("CategoryController.delete");
//        return "del,name";
//    }

    /*
     * 同一个请求路径中，允许有多个`{}`占位符，则处理请求的方法也应该有多个对应的参数，
     * 每个参数前都添加`@PathVariable`即可。
     *如果占位符的名称与方法的参数名称不匹配，还可以在`@PathVariable`注解中配置参数名称，
     * 注解中配置的名称应该与占位符中的名称一致，例如：
     *```
     *@RequestMapping("/{id}/edit")
     *public String edit(@PathVariable("id") Long brandId, BrandEditDTO brandEditDTO) {
     *   // 暂不关心方法体的代码
     *}
     */
    @ApiOperation("根据id删除类别")
    @ApiOperationSupport(order = 20)
    @PostMapping("/{id:[0-9]+}/delete")
//     public JsonResult delete(@RequestBody @Valid CategoryDeleteDTO categoryDeleteDTO){
//             categoryService.delete(categoryDeleteDTO);
    public JsonResult delete(@PathVariable Long id) {
        log.info("接收到删除类别的请求,参数id:{}", id);
        categoryService.deleteById(id);
        return JsonResult.ok();
    }

    @ApiOperation("修改类别")
    @ApiOperationSupport(order = 30)
    @PostMapping("/{id}/update/{name}")
    public JsonResult update(@PathVariable("id")Long id,@PathVariable("name") String name) {
        log.info("接收到修改类别的请求,参数id:{},参数名称:{}", id,name);
        categoryService.updateById(id,name);
        return JsonResult.ok();
    }

    //访问路径 http://localhost:8080/category
    // @RequestMapping("/list")
    // @RequestMapping("")
    @ApiOperation("查询类别列表")
    @ApiOperationSupport(order = 40)
    @GetMapping("")
    public JsonResult list() {
        log.info("CategoryController.list");
        List<CategoryListItemVO> list = categoryService.list();
        return JsonResult.ok(list);
    }
}
