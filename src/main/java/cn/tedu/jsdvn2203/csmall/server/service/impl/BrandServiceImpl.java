package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.mapper.BrandMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandDeleteDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.ServletException;

@Slf4j

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    public IBrandRepository brandRepository;

    @Autowired
    BrandMapper brandMapper;

    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {
//        String s = null;//测试
//        System.out.println(s.length());//测试

        //检查品牌名称是否被占用
        String name = brandAddNewDTO.getName();
        int count = brandMapper.countByName(name);
        if (count > 0) {
            String message = "添加失败,品牌名称[" + name + "]已存在";
            log.error(message);
            throw new ServiceException(message);
        }

        //创建实体对象(Mapper的方法参数是实体类型)
        Brand brand = new Brand();
        //将当前方法参数的值复制到brand 实体类型的对象中
        BeanUtils.copyProperties(brandAddNewDTO, brand);
        //补齐属性值
        brand.setSales(0);
        brand.setProductCount(0);
        brand.setCommentCount(0);
        brand.setPositiveCommentCount(0);
        brand.setEnable(0);
        int rows = brandMapper.insert(brand);
        log.info("插入成功,受影响的行数", rows);

    }


    @Override
    public void delete(BrandDeleteDTO brandDeleteDTO) {
        Brand brand = new Brand();
        BeanUtils.copyProperties(brandDeleteDTO, brand);
        int rows = brandMapper.deleteById(brand.getId());
        log.info("删除成功，受影响的行数：{}", rows);
    }
}
