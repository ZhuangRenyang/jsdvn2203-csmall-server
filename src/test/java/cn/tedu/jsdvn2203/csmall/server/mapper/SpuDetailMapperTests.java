package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.SpuDetail;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SpuDetailMapperTests {

    @Autowired
    SpuDetailMapper spuDetailMapper;

    @Test
    public void testInsert(){
        Long spuId = 10L;
        String detail = "哈哈哈哈哈哈";
        SpuDetail spuDetail = new SpuDetail();
        spuDetail.setSpuId(spuId);
        spuDetail.setDetail(detail);
        int rows = spuDetailMapper.insert(spuDetail);
        log.info("插入成功，受影响的行数：{}",rows);
    }

    @Test
    public void testDeleteById(){
        Long id = 10L;
        int rows = spuDetailMapper.deleteById(id);
        log.info("删除成功，受影响的行数：{}",rows);
    }

    @Test
    public void testDeleteByIds(){
        Long id[] = {10L,11L,12L};
        int rows = spuDetailMapper.deleteByIds(id);
        log.info("批量删除成功，受影响的行数：{}",rows);
    }
}
