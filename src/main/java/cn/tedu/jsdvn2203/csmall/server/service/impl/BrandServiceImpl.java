package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.mapper.BrandMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Slf4j

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    public IBrandRepository brandRepository;

    @Autowired
    BrandMapper brandMapper;
    @Override
    public void addNew(BrandAddNewDTO brandAddNewDTO) {
        //创建实体对象(Mapper的方法参数是实体类型)
        Brand brand = new Brand();
        //将当前方法参数的值复制到brand 实体类型的对象中
        BeanUtils.copyProperties(brandAddNewDTO,brand);
        int rows = brandMapper.insert(brand);
        log.info("插入成功,受影响的行数",rows);

    }
}
