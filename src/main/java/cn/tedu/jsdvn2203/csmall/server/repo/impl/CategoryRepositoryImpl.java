package cn.tedu.jsdvn2203.csmall.server.repo.impl;

import cn.tedu.jsdvn2203.csmall.server.repo.ICategoryRepository;
import org.springframework.stereotype.Repository;

@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {
    public CategoryRepositoryImpl() {
        System.out.println("创建控制器访问对象:CategoryRepositoryImpl");
    }
}
