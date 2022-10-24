package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Attribute;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeMapper {

    int insert(Attribute attribute);

    int deleteById(Long id);

    int deleteByIds(Long... ids);


}
