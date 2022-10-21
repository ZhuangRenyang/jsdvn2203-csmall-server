package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
        System.out.println("插入成功,受影响的行数为:"+rows+",id值为:"+id);
    }
}
