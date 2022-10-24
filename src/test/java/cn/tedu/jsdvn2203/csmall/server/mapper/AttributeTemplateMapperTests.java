package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.AttributeTemplate;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class AttributeTemplateMapperTests {

    @Autowired
    AttributeTemplateMapper attributeTemplateMapper;

    @Test
    public void testInsert() {
        String name = "哈哈哈";
        String pinyin = "hhhh";
        int sort = 0;
        AttributeTemplate attributeTemplate = new AttributeTemplate();
        attributeTemplate.setName(name);
        attributeTemplate.setPinyin(pinyin);
        attributeTemplate.setSort(sort);
        int rows = attributeTemplateMapper.insert(attributeTemplate);
        log.info("插入成功，受影响的行数有：{}", rows);
    }

    @Test
    public void testDeleteById() {
        Long id = 6L;
        int rows = attributeTemplateMapper.deleteById(id);
        log.info("删除成功，受影响的行数：{}", rows);
    }

    @Test
    public void testDeleteByIds(){
       int rows = attributeTemplateMapper.deleteByIds(6L,7l,8L);
        log.info("批量删除成功，受影响的行数，{}" ,rows);
    }
}
