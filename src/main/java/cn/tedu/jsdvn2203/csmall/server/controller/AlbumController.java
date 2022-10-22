package cn.tedu.jsdvn2203.csmall.server.controller;

import cn.tedu.jsdvn2203.csmall.server.service.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@Lazy
@RestController
public class AlbumController {
    public AlbumController() {
        log.info("创建相册控制器对象.AlbumController");
    }
    @Autowired
    private IAlbumService albumService;
}
