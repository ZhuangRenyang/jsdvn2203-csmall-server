package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.BrandCategory;
import org.springframework.stereotype.Repository;

@Repository
public interface BrandCategoryMapper {

    int insert(BrandCategory brandCategory);

    int deleteById(Long id);

    int deleteByIds(Long... ids);
}
