package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    public BrandController() {
        log.info("创建控制器对象.BrandController");
    }

    @RequestMapping("/add-new")
    public String addNew(BrandAddNewDTO brandAddNewDTO){
        log.info("brandAddNewDTO:{}",brandAddNewDTO);
        log.info("BrandController.add-new");
        return "add-new";
    }
    //访问路径http://localhost:8080/brands/delete?id=123&...
    @RequestMapping("/delete")
    public String delete(Long id){
        log.info("delete-id:{}",id);
        log.info("BrandController.delete");
        return "delete:"+id;
    }

    @RequestMapping("/update")
    public String update(Long id){
        log.info("update-id:{}",id);
        log.info("BrandController.update");
        return "update:"+id;
    }

    @RequestMapping("/list")
    public String list(){
        log.info("BrandController.list");
        return "list";
    }
}
