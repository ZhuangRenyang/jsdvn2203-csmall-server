package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.SkuSpecification;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class SkuSpecificationMapperTests {

    @Autowired
    SkuSpecificationMapper skuSpecificationMapper;

    @Test
    public void testInsert(){
        Long skuId =10L;
        Long attributeId = 10L;
        SkuSpecification skuSpecification = new SkuSpecification();
        skuSpecification.setSkuId(skuId);
        skuSpecification.setAttributeId(attributeId);
        int rows = skuSpecificationMapper.insert(skuSpecification);
        log.info("插入成功，受影响的行数：{}",rows);
    }

    @Test
    public void testDeleteById(){
        Long id = 10L;
        int rows = skuSpecificationMapper.deleteById(id);
        log.info("删除成功，受影响的行数：{}",rows);
    }

    @Test
    public void testDeleteByIds(){
        int rows = skuSpecificationMapper.deleteByIds(10L, 11L, 12L);
        log.info("删除成功，受影响的行数：{}",rows);
    }
}
