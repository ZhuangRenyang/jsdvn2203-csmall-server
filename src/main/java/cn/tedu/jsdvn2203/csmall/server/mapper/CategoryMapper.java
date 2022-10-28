package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Category;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryMapper {

    int insert(Category category);

    int deleteById(Long id);

    int deleteByIds(Long... id);

    int countByName(String name);

    int countById(Long id);
}
