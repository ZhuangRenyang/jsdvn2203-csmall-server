package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.service.ICategoryService;
import org.springframework.stereotype.Service;

@Service
public class CategoryServiceImpl implements ICategoryService {
    public CategoryServiceImpl(){
        System.out.println("创建业务逻辑对象.CategoryService");
    }
}
