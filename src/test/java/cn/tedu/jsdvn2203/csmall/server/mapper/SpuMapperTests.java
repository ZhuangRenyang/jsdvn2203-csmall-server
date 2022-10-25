package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Spu;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SpuMapperTests {

    @Autowired
    SpuMapper spuMapper;

    @Test
    public void testInsert(){
        Long id = 202112010000003L;
        String name = "哈哈哈";
        String typeNumber = "4652346";
        String title = "hhhh";
        Spu spu = new Spu();
        spu.setName(name);
        spu.setTypeNumber(typeNumber);
        spu.setTitle(title);
        spu.setId(id);
        int rows = spuMapper.insert(spu);
        log.info("插入成功，受影响的行数：{}",rows);
    }

    @Test
    public void deleteById(){
        Long id = 202112010000003L;
        int rows = spuMapper.deleteById(id);
        log.info("删除成功，受影响的行数：{}",rows);
    }

    @Test
    public  void deleteByIds(){
        Long id[] = {202112010000003L,202112010000004L,202112010000005L};
        int rows = spuMapper.deleteByIds(id);
        log.info("批量删除成功，受影响的行数：{}",rows);
    }
}
