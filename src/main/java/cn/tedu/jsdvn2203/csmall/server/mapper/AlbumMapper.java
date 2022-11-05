package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Album;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AlbumMapper {

    /**
     * 新建相册
     * @param album 相册数据
     * @return 受影响的行数
     */
    int insert(Album album);

    /**
     * 根据相册id删除相册数据
     *
     * @param id 期望删除的相册数据的id
     * @return 受影响的行数，当删除成功时，返回1，如果无此id对应的数据，则返回0
     */
    int deleteById(Long id);

    int deleteByIds(Long... ids);

    int updateNameById(@Param("id") Long id,@Param("name") String name);

    int countByName(String name);

    int countById(Long id);
}
