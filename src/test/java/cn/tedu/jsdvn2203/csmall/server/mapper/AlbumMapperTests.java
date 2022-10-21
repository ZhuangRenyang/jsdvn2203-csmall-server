package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Album;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.swing.plaf.PanelUI;

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
    @Test
    public void testDeleteById(){
        Long id = 1L;
        int rows = albumMapper.deleteById(id);
        System.out.println("删除完成，受影响的行数="+rows);

    }

    @Test
    public void testUpdateById(){
        Long id = 3L;
        String name = "萝卜";
        int rows = albumMapper.updateNameById(id, name);
        System.out.println("修改完成，受影响的行数="+rows);
    }
}
