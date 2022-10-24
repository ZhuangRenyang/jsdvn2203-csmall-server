package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Album;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AlbumMapperTests {
    @Autowired
    AlbumMapper albumMapper;

    @Test
    public void testInsert(){
        Album album = new Album();
        album.setName("(*Φ皿Φ*)");
        int rows = albumMapper.insert(album);
        Long id = album.getId();
        log.info("插入成功,受影响的行数为:{},id值为:{}",rows,id);
    }
    @Test
    public void testDeleteById(){
        Long id = 1L;
        int rows = albumMapper.deleteById(id);
        log.info("删除完成，受影响的行数={}",rows);

    }

    @Test
    public void testDeleteByIds(){
        int rows = albumMapper.deleteByIds(1L,2L,3L);
        log.info("批量删除完成，受影响的行数={}",rows);
    }

    @Test
    public void testUpdateById(){
        Long id = 3L;
        String name = "萝卜";
        int rows = albumMapper.updateNameById(id, name);
        log.info("修改完成，受影响的行数={}",rows);
    }


}
