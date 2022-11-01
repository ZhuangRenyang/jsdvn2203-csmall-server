package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandDeleteDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
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
@Api(tags = "2.品牌管理模块")
@RestController
@RequestMapping("/brands")
public class BrandController {

    @Autowired
    private IBrandService brandService;

    public BrandController() {
        log.info("创建控制器对象.BrandController");
    }


    @ApiOperation("添加品牌")
    @ApiOperationSupport(order = 10)
    @PostMapping("/add-new")
    public JsonResult addNew(@RequestBody @Valid BrandAddNewDTO brandAddNewDTO) {
        log.debug("接收到添加品牌的请求,参数:{}", brandAddNewDTO);
        brandService.addNew(brandAddNewDTO);
        return JsonResult.ok();
    }

    //访问路径http://localhost:8080/brands/delete?id=123&...
    @ApiOperation("根据id删除品牌")
    @ApiOperationSupport(order = 20)
    @PostMapping("/delete")
    public String delete(BrandDeleteDTO brandDeleteDTO) {
        log.debug("接收到删除品牌的请求,参数:{}", brandDeleteDTO.getId());
        brandService.delete(brandDeleteDTO);
        return "delete:";
    }

    @ApiOperation("修改品牌")
    @ApiOperationSupport(order = 30)
    @PostMapping("/update")
    public String update(Long id) {
        log.info("update-id:{}", id);
        log.info("BrandController.update");
        return "update:" + id;
    }

    @ApiOperation("查询品牌列表")
    @ApiOperationSupport(order = 40)
    @GetMapping("")
    public JsonResult list() {
        log.info("BrandController.list");
        List<BrandListItemVO> list = brandService.list();
        return JsonResult.ok(list);
    }
}
