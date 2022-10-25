package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.SkuSpecification;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuSpecificationMapper {

    int insert(SkuSpecification skuSpecification);

    int deleteById(Long id);

    int deleteByIds(Long... id);
}
