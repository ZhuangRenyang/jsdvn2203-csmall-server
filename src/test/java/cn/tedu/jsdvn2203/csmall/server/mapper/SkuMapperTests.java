package cn.tedu.jsdvn2203.csmall.server.mapper;


import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Sku;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class SkuMapperTests {

    @Autowired
    SkuMapper skuMapper;

    @Test
    public void testInsert(){
        Long id = 202112010000003L;
        String title = "哈哈哈";
        Sku sku = new Sku();
        sku.setTitle(title);
        sku.setId(id);
        int rows = skuMapper.insert(sku);
        log.info("插入成功，受影响的行数：{}",rows);
    }

    @Test
    public void testDeleteById(){
        Long id = 202112010000003L;
        int rows = skuMapper.deleteById(id);
        log.info("删除成功，受影响的行数：{}",rows);
    }

    @Test
    public void testDeleteByIds(){
        Long id[] = {202112010000003L,202112010000004L,202112010000004L};
        int rows = skuMapper.deleteByIds(id);
        log.info("批量删除成功，受影响的行数：{}",rows);
    }
}
