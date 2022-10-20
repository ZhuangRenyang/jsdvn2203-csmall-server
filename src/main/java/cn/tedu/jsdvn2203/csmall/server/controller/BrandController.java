package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    public BrandController() {
        System.out.println("创建控制器对象.BrandController");
    }

    @RequestMapping("/add-new")
    public String addNew(BrandAddNewDTO brandAddNewDTO){
        System.out.println("brandAddNewDTO:"+brandAddNewDTO);
        System.out.println("BrandController.add-new");
        return "add-new";
    }
    //访问路径http://localhost:8080/brands/delete?id=123&...
    @RequestMapping("/delete")
    public String delete(Long id){
        System.out.println("delete-id:"+id);
        System.out.println("BrandController.delete");
        return "delete:"+id;
    }
    @RequestMapping("/update")
    public String update(Long id){
        System.out.println("update-id:"+id);
        System.out.println("BrandController.update");
        return "update:"+id;
    }
    @RequestMapping("/list")
    public String list(){
        System.out.println("BrandController.list");
        return "list";
    }
}
