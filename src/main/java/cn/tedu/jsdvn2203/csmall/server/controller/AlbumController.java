package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.service.IAlbumService;
import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
//@Lazy
@Api(tags = "3.图片管理模块")
@RestController
@RequestMapping("/album")
public class AlbumController {
    public AlbumController() {
        log.info("创建相册控制器对象.AlbumController");
    }
    @Autowired
    private IAlbumService albumService;

    public AlbumController(IAlbumService albumService) {
        log.info("创建相册控制器对象.AlbumController");
    }
    @ApiOperation("添加相册")
    @ApiOperationSupport(order = 10)
    @PostMapping("/add-new")
    public String addNew(AlbumAddNewDTO albumAddNewDTO){
        log.debug("接收到添加相册的请求,参数:{}",albumAddNewDTO);
            albumService.addNew(albumAddNewDTO);
        return "ok";
    }

    @ApiOperation("删除相册")
    @ApiOperationSupport(order = 20)
    @PostMapping("/delete")
    public String delete(){
        log.debug("接收到删除相册的请求,参数:{}");
        return "delete";
    }
}
