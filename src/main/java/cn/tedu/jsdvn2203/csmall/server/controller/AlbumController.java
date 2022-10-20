package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.service.IAlbumService;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

@Lazy
@RestController
public class AlbumController {
    public AlbumController() {
        System.out.println("创建相册控制器对象.AlbumController");
    }
    @Autowired
    private IAlbumService albumService;
}
