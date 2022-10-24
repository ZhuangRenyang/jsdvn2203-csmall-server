package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Album;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumMapper {
    int insert(Album album);

    int deleteById(Long id);

    int deleteByIds(Long... ids);

    int updateNameById(@Param("id") Long id,@Param("name") String name);



}
