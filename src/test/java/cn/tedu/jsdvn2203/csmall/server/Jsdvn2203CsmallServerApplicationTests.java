package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.controller.AlbumController;
import cn.tedu.jsdvn2203.csmall.server.controller.BrandController;
import cn.tedu.jsdvn2203.csmall.server.controller.CategoryController;
import cn.tedu.jsdvn2203.csmall.server.controller.PictureController;
import cn.tedu.jsdvn2203.csmall.server.repo.impl.BrandRepositoryImpl;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import cn.tedu.jsdvn2203.csmall.server.repo.ICategoryRepository;
import cn.tedu.jsdvn2203.csmall.server.service.impl.AlbumServiceImpl;
import cn.tedu.jsdvn2203.csmall.server.service.impl.BrandServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.util.Date;

@Slf4j
@SpringBootTest
class Jsdvn2203CsmallServerApplicationTests {

    @Autowired
    public ApplicationContext ac; //Spring容器
//    public AnnotationConfigApplicationContext ac; //Spring-boot-starter
//    public GenericWebApplicationContext ac;  //Spring-boot-starter-web

    @Autowired
    public ICategoryRepository categoryRepository;

//    @Autowired
//    public CategoryRepositoryImpl categoryRepository;

    @Test
    void contextLoads() {
        PictureController pictureController = ac.getBean(PictureController.class);
        log.info("{}",pictureController);
        AlbumController albumController = ac.getBean(AlbumController.class);
        log.info("{}",albumController);
        log.info("{}",categoryRepository);
    }

    @Autowired
    CategoryController categoryController;
    @Autowired
    Date date;
    @Autowired
    BrandController brandController;

    @Test
    public void testAutowired(){
        log.info("{}",categoryController);
        log.info("{}",date);
        log.info("{}",brandController);
    }

    @Autowired
    BrandServiceImpl brandService;
    @Autowired
    BrandRepositoryImpl brandRepository1;
    @Autowired
    IBrandRepository brandRepository2;

    @Test
    public void testBrandAutowired(){
        log.info("通过Service:{}",brandService.brandRepository);
        log.info("通过实现类获取:{}",brandRepository1);
        log.info("通过接口获取:{}",brandRepository2);
    }
    @Autowired
    AlbumServiceImpl albumService;
    @Test
    public void testAlbumAutowired(){//对象的唯一性
        log.info("通过Service:{}",albumService);
    }
}
