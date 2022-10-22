package cn.tedu.jsdvn2203.csmall.server.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;
@Slf4j
@RestController
public class PictureController {
    public PictureController() {
        log.info("创建照片控制器对象.PictureController");
    }
}
