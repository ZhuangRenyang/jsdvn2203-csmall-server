package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.CategoryAttributeTemplate;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryAttributeTemplateMapper {

    int insert(CategoryAttributeTemplate categoryAttributeTemplate);

    int deleteById(Long id);

    int deleteByIds(Long... id);
}
