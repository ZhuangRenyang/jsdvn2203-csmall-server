package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Picture;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class PictureMapperTests {

    @Autowired
    PictureMapper pictureMapper;

    @Test
    public void testInsert(){
        Long albumId = 10L;
        String url = "嘿嘿嘿";
        String description = "hhhh";
        Picture picture = new Picture();
        picture.setAlbumId(albumId);
        picture.setUrl(url);
        picture.setDescription(description);
        int rows = pictureMapper.insert(picture);
        log.info("插入成功,受影响的行数：{}",rows);
    }
}
