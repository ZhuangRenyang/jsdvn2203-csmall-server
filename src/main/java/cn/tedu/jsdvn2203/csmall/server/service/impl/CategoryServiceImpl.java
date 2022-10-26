package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.mapper.CategoryMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryDeleteDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Category;
import cn.tedu.jsdvn2203.csmall.server.service.ICategoryService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryServiceImpl(){
        log.info("创建业务逻辑对象.CategoryService");
    }

    @Override
    public void addNew(CategoryAddNewDTO categoryAddNewDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryAddNewDTO,category);
        int rows = categoryMapper.insert(category);
        log.info("插入成功，受影响的行数：{}",rows);
    }

    @Override
    public void delete(CategoryDeleteDTO categoryDeleteDTO) {
        Category category = new Category();
        BeanUtils.copyProperties(categoryDeleteDTO,category);
        int rows = categoryMapper.deleteById(category.getId());
        log.info("删除成功,受影响的行数:{}",rows);
    }
}
