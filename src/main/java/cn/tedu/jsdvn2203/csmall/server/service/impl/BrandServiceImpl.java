package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.config.BeanConfig;
import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.mapper.BrandMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
import cn.tedu.jsdvn2203.csmall.server.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    public IBrandRepository brandRepository;

    @Autowired
    BrandMapper brandMapper;

    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {

        //检查品牌名称是否被占用
        String name = brandAddNewDTO.getName();//获取品牌的名称
        int count = brandMapper.countByName(name);//查询是否有该名称
        if (count > 0) {
            String message = "添加失败,品牌名称[" + name + "]已存在";
            log.error(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);//错误：冲突 - 重复数据
        }

        //创建实体对象(Mapper的方法参数是实体类型)
        Brand brand = new Brand();
        //将当前方法参数的值复制到brand 实体类型的对象中
        BeanUtils.copyProperties(brandAddNewDTO, brand);//类型转换赋值
        //补齐属性值
//        brand.setSales(0);
//        brand.setProductCount(0);
//        brand.setCommentCount(0);
//        brand.setPositiveCommentCount(0);
//        brand.setEnable(0);
        brand.setGmtCreate(BeanConfig.localDateTime());//创建时间
        int rows = brandMapper.insert(brand);//执行插入
        if (rows != 1){
            String message = "添加品牌失败,服务器忙,请稍后重试!";
            throw new ServiceException(ServiceCode.ERR_INSERT,message);//错误：插入失败
        }
        log.info("插入成功,受影响的行数", rows);

    }

    @Override
    public List<BrandListItemVO> list() {
        log.debug("处理查询品牌列表的业务...");
        return brandMapper.list();
    }

//    @Override
//    public void deleteById(BrandDeleteDTO brandDeleteDTO) {
//        //检查品牌id是否存在
//        Long id = brandDeleteDTO.getId();//获取品牌id的名称
//        int count = brandMapper.countById(id);//查询是否存在该id
//        if (count==0){
//            String message = "删除失败,品牌id["+id+"]不存在";
//            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);//错误：冲突 - 重复数据
//        }
//
//        Brand brand = new Brand();
//        BeanUtils.copyProperties(brandDeleteDTO, brand);//类型转换赋值
//        int rows = brandMapper.deleteById(brand.getId());//执行删除
//        if (rows != 1){
//            String message = "删除品牌失败,服务器忙,请稍后重试!";
//            log.error(message);
//            throw new ServiceException(ServiceCode.ERR_INSERT, message);//错误：删除失败
//        }
//        log.info("删除成功，受影响的行数：{}", rows);
//    }


    @Override
    public void deleteById(Long id) {
        log.debug("处理删除品牌数据的业务，id={}",id);
        BrandDetailVO brandDetailVO = brandMapper.getById(id);
        if (brandDetailVO == null){
            String message = "删除品牌失败,删除的数据(id:"+id+")不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND,message);
        }
        //调用mapper删除方法并返回值
        int rows = brandMapper.deleteById(id);
        if (rows != 1){
            String message = "删除失败,服务器忙,请稍后重试";
            throw new ServiceException(ServiceCode.ERR_DELETE,message);
        }
    }
    @Override
    public void updateById(Long id,String name) {
        BrandDetailVO brandDetailVO = brandMapper.getById(id);
        if (brandDetailVO==null){
            String message = "修改品牌名称失败，修改的数据(id:" + id + ")不存在";
            throw new ServiceException(ServiceCode.ERR_NOT_FOUND, message);
        }
        Brand brand = new Brand();
        brand.setId(id);
        brand.setName(name);
        brand.setGmtModified(BeanConfig.localDateTime());
        int rows = brandMapper.updateById(brand);
        if (rows != 1) {
            String message = "修改品牌名称失败，服务器忙，请稍后重试~";
            throw new ServiceException(ServiceCode.ERR_DELETE, message);
        }
        log.info("修改的品牌id为:{},名称为:{}",id,name);
        log.info("修改品牌名称成功~");
    }
}
