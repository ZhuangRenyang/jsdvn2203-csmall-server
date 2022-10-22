package cn.tedu.jsdvn2203.csmall.server.repo.impl;

import cn.tedu.jsdvn2203.csmall.server.repo.ICategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;
@Slf4j
@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {
    public CategoryRepositoryImpl() {
        log.info("创建控制器访问对象:CategoryRepositoryImpl");
    }
}
