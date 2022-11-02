package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.config.BeanConfig;
import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.mapper.CategoryMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryDeleteDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Category;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.ICategoryService;
import cn.tedu.jsdvn2203.csmall.server.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class CategoryServiceImpl implements ICategoryService {

    @Autowired
    CategoryMapper categoryMapper;

    public CategoryServiceImpl() {
        log.info("创建业务逻辑对象.CategoryService");
    }

    @Override
    public void insert(CategoryAddNewDTO categoryAddNewDTO) {
        //检查类别名称是否被占用
        String name = categoryAddNewDTO.getName();//获取类别名称
        int count = categoryMapper.countByName(name);//查询是否有该名称
        if (count > 0) {
            String message = "添加失败,类别名称[" + name + "]已存在";
            log.error(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);//错误：冲突 - 重复数据
        }

        Category category = new Category();//创建实体类
        BeanUtils.copyProperties(categoryAddNewDTO, category);//类型转换赋值
        category.setGmtCreate(BeanConfig.localDateTime());
        int rows = categoryMapper.insert(category);//执行插入
        if (rows != 1) {
            String message = "添加品牌失败,服务器忙,请稍后重试!";
            log.error(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);//错误：插入失败
        }
        log.info("插入成功，受影响的行数：{}", rows);
    }

    @Override
    public List<CategoryListItemVO> list() {
        log.debug("处理查询分类列表的业务...");
        return categoryMapper.list();
    }

    @Override
    public void delete(CategoryDeleteDTO categoryDeleteDTO) {
        //检查类别id是否存在
        Long id = categoryDeleteDTO.getId();//获取类别id
        int count = categoryMapper.countById(id);//查询是否有该id
        if (count == 0) {
            String message = "删除失败，类别id[" + id + "]不存在";
            log.info("删除失败:{}", message);
            throw new ServiceException(ServiceCode.ERR_DELETE, message);//错误：冲突 - 重复数据
        }
        Category category = new Category();//创建实体类
        BeanUtils.copyProperties(categoryDeleteDTO, category);//类型转换赋值
        int rows = categoryMapper.deleteById(category.getId());//执行删除
        if (rows != 1){
            String message = "删除类别失败,服务器忙,请稍后重试!";
            log.error(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);//错误：删除失败
        }
        log.info("删除成功,受影响的行数:{}", rows);
    }

}
