package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.CategoryAttributeTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CategoryAttributeTemplateMapperTests {

    @Autowired
    CategoryAttributeTemplateMapper categoryAttributeTemplateMapper;

    @Test
    public void testInsert() {
        Long categoryId = 10L;
        Long attributeTemplateId = 11L;
        CategoryAttributeTemplate categoryAttributeTemplate = new CategoryAttributeTemplate();
        categoryAttributeTemplate.setCategoryId(categoryId);
        categoryAttributeTemplate.setAttributeTemplateId(attributeTemplateId);
        int rows = categoryAttributeTemplateMapper.insert(categoryAttributeTemplate);
        log.info("插入成功,受影响的行数:{}", rows);
    }

    @Test
    public void testDeleteById() {
        Long id = 10L;
        int rows = categoryAttributeTemplateMapper.deleteById(id);
        log.info("删除成功,受影响的行数:{}", rows);
    }

    @Test
    public void testDeleteByIds() {
        int rows = categoryAttributeTemplateMapper.deleteByIds(10L, 11L, 12L);
        log.info("批量删除成功,受影响的行数:{}", rows);
    }
}
