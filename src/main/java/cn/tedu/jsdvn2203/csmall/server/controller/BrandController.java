package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandDeleteDTO;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Api(tags = "2.品牌管理模块")
@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    public BrandController() {
        log.info("创建控制器对象.BrandController");
    }

    //测试 http://localhost:8080/doc.html#/home
    @ApiOperation("添加品牌")
    @ApiOperationSupport(order = 10)
    @PostMapping("/add-new")
    public String addNew(BrandAddNewDTO brandAddNewDTO){
        log.debug("接收到添加品牌的请求,参数:{}",brandAddNewDTO);
        try {
            brandService.addNew(brandAddNewDTO);
        }catch (ServiceException e){
            return e.getMessage();
        }
        return "ok";
    }
    //访问路径http://localhost:8080/brands/delete?id=123&...
    @ApiOperation("根据id删除品牌")
    @ApiOperationSupport(order = 20)
    @PostMapping("/delete")
    public String delete(BrandDeleteDTO brandDeleteDTO){
        log.debug("接收到删除品牌的请求,参数:{}",brandDeleteDTO.getId());
        brandService.delete(brandDeleteDTO);
        return "delete:";
    }

    @ApiOperation("修改品牌")
    @ApiOperationSupport(order = 30)
    @PostMapping("/update")
    public String update(Long id){
        log.info("update-id:{}",id);
        log.info("BrandController.update");
        return "update:"+id;
    }

    @ApiOperation("查询品牌列表")
    @ApiOperationSupport(order = 40)
    @GetMapping("/list")
    public String list(){
        log.info("BrandController.list");
        return "list";
    }
}
