package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Sku;
import org.springframework.stereotype.Repository;

@Repository
public interface SkuMapper {

    int insert(Sku sku);

    int deleteById(Long id);

    int deleteByIds(Long... id);
}
