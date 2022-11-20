package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.config.BeanConfig;
import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.mapper.CategoryMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Category;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;
import cn.tedu.jsdvn2203.csmall.server.service.ICategoryService;
import cn.tedu.jsdvn2203.csmall.server.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
    @Transactional
    public void insert(CategoryAddNewDTO categoryAddNewDTO) {
        log.debug("开始处理添加类别的业务，参数：{}", categoryAddNewDTO);

        // 获取参数中的parentId
        Long parentId = categoryAddNewDTO.getParentId();
        CategoryDetailVO parentCategory = null;
        // 获取父级类别对象
        if(parentId != 0){
            parentCategory = categoryMapper.getById(parentId);
            //判断父级类别是否存在，如果不存在，抛出异常
            if(parentCategory == null){
                String message = "添加类别失败，父级类别不存在";
                throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
            }
        }

        // 检查此类别（尝试创建的类别）的名称有没有被使用
        // 如果已经被使用，则不允许创建
        String name = categoryAddNewDTO.getName();//获取类别名称
        int count = categoryMapper.countByName(name);//查询是否有该名称
        if (count > 0) {
            String message = "添加失败,类别名称[" + name + "]已存在";
            log.error(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT, message);//错误：冲突 - 重复数据
        }

        // 创建实体对象（Mapper的方法的参数是实体类型）
        Category category = new Category();//创建实体类
        // 将当前方法参数的值复制到Brand实体类型的对象中
        BeanUtils.copyProperties(categoryAddNewDTO, category);//类型转换赋值
        if(parentId == 0){//判断parentId是否为父级
            category.setDepth(1);//父级为0深度+1
        }else{//如果为父级，父级的深度+1
            category.setDepth(parentCategory.getDepth() + 1);
        }
        // 此时类别是新的类别，不会有子级，所以isParent固定为0
        category.setIsParent(0);

        category.setGmtCreate(BeanConfig.localDateTime());//创建时间
        // 将类别数据写入到数据库中
        log.debug("即将向表中写入数据：{}", category);
        int rows = categoryMapper.insert(category);//执行插入
        if (rows != 1) {
            String message = "添加品牌失败,服务器忙,请稍后重试!";
            log.error(message);
            throw new ServiceException(ServiceCode.ERR_INSERT, message);//错误：插入失败
        }
        log.info("插入成功，受影响的行数：{}", rows);
        // 如果parentId不为0，父级类别的isParent为0
        if(parentId != 0 && parentCategory.getIsParent() == 0){
            Category c = new Category();
            c.setId(parentId);//父类的id
            c.setIsParent(1);//修改父类为父级，1=是，0=不是
            rows = categoryMapper.updateById(c);
            if (rows != 1) {
                String message = "添加类别失败，请稍后再次尝试！【错误码：2】";
                log.error(message);
                throw new ServiceException(ServiceCode.ERR_INSERT, message);
            }
        }

    }

    @Override
    public List<CategoryListItemVO> list() {
        log.debug("处理查询分类列表的业务...");
        return categoryMapper.list();
    }

    //    @Override
//    public void delete(CategoryDeleteDTO categoryDeleteDTO) {
//        //检查类别id是否存在
//        Long id = categoryDeleteDTO.getId();//获取类别id
//        int count = categoryMapper.countById(id);//查询是否有该id
//        if (count == 0) {
//            String message = "删除失败，类别id[" + id + "]不存在";
//            log.info("删除失败:{}", message);
//            throw new ServiceException(ServiceCode.ERR_DELETE, message);//错误：冲突 - 重复数据
//        }
//        Category category = new Category();//创建实体类
//        BeanUtils.copyProperties(categoryDeleteDTO, category);//类型转换赋值
//        int rows = categoryMapper.deleteById(category.getId());//执行删除
//        if (rows != 1){
//            String message = "删除类别失败,服务器忙,请稍后重试!";
//            log.error(message);
//            throw new ServiceException(ServiceCode.ERR_INSERT, message);//错误：删除失败
//        }
//        log.info("删除成功,受影响的行数:{}", rows);
//    }
    @Override
    @Transactional
    public void deleteById(Long id) {
        log.debug("开始处理删除类别的业务，id={}", id);

        // 根据id查询数据
        CategoryDetailVO queryResult = categoryMapper.getById(id);

        // 判断查询结果是否为null
        if (queryResult == null) {
            // 抛出异常
            String message = "删除类别失败，尝试删除的数据（id=" + id + "）不存在！";
            log.error(message);
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }

        //  4.检查当前类别是否存在子级类别
        {
            int count = categoryMapper.countByParentId(id);
            if(count > 0){
                String message = "删除类别失败，当前类别仍存在子级类别，不允许删除！";
                log.error(message);
                throw new ServiceException(ServiceCode.ERR_CONFLICT, message);
            }
        }

        int rows = categoryMapper.deleteById(id);
        if (rows != 1) {
            String message = "删除品牌失败，服务器忙，请稍后重试~";
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        }
        // 目标: 检查是否有必要将父级类别的isParent改为0
        // 步骤：
        //  1.根据此前的检查结果得到parentId
        Long parentId = queryResult.getParentId();
        //  2.开发Mapper层:根据父级类别id统计子级类别的数量
        int count = categoryMapper.countByParentId(parentId);
        //  3.检查是否有必要将父级类别的isParent改为0
        //   判断: 统计当前类别的父级类别有多少个子级，判断您是否等于0
        if(count == 0){
            //   是: 将父级类别的isParent改为0
            Category category = new Category();
            category.setId(parentId);
            category.setIsParent(0);
            rows = categoryMapper.updateById(category);
            if (rows != 1) {
                // 抛出异常
                String message = "删除类别失败，服务器忙，请稍后再次尝试！【错误码：2】";
                log.error(message);
                throw new ServiceException(ServiceCode.ERR_DELETE, message);
            }
        }
    }

    @Override
    public void updateById(Long id, String name) {
        CategoryDetailVO categoryDetailVO = categoryMapper.getById(id);
        if (categoryDetailVO == null) {
            String message = "修改类别名称失败，修改的数据(id:" + id + ")不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        Category category = new Category();
        category.setId(id);
        category.setName(name);
        category.setGmtModified(BeanConfig.localDateTime());//创建时间
        int rows = categoryMapper.updateById(category);
        if (rows != 1) {
            String message = "修改类别名称失败，服务器忙，请稍后重试~";
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        }
        log.info("修改的类别id为:{},名称为:{}",id,name);
        log.info("修改类别名称成功~");
    }
}
