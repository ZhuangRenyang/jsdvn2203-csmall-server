package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Picture;
import org.springframework.stereotype.Repository;

@Repository
public interface PictureMapper {

    int insert(Picture picture);

    int deleteById(Long id);

    int deleteByIds(Long... id);
}
