package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface BrandMapper {
int insert(Brand brand);
}
