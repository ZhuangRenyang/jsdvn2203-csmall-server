package cn.tedu.jsdvn2203.csmall.server.mapper;


import cn.tedu.jsdvn2203.csmall.server.pojo.entity.AttributeTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface AttributeTemplateMapper {

    int insert(AttributeTemplate attributeTemplate);

    int deleteById(Long id);

    int deleteByIds(Long... ids);
}
