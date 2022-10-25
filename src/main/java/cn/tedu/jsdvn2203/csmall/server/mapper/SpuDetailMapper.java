package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.SpuDetail;
import org.springframework.stereotype.Repository;

@Repository
public interface SpuDetailMapper {

    int insert(SpuDetail spuDetail);

    int deleteById(Long id);

    int deleteByIds(Long... id);
}
