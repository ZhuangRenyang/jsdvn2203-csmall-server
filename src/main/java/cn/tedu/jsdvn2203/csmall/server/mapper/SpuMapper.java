package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Spu;
import org.springframework.stereotype.Repository;

@Repository
public interface SpuMapper {

    int insert(Spu spu);

    int deleteById(Long id);

    int deleteByIds(Long... id);
}
