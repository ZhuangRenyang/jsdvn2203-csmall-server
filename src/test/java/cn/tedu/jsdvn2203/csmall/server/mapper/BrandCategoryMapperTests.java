package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.BrandCategory;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class BrandCategoryMapperTests {
    @Autowired
   BrandCategoryMapper brandCategoryMapper;

    @Test
    public void testInsert() {
        Long brandId = 16L;
        Long categoryId = 10L;
        BrandCategory brandCategory = new BrandCategory();
        brandCategory.setCategoryId(categoryId);
        brandCategory.setBrandId(brandId);
        int rows = brandCategoryMapper.insert(brandCategory);
        log.info("插入成功，受影响的行数：{}",rows);
    }
}
