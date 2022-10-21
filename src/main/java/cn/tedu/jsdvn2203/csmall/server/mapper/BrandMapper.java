package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface BrandMapper {
int insert(Brand brand);

int deleteById(Long id);

int updateNameById(@Param("id") Long id,@Param("name") String name);
}
