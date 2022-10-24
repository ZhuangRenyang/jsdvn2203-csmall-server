package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Attribute;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@Slf4j
@SpringBootTest
public class AttributeMapperTests {

    @Autowired
    AttributeMapper attributeMapper;

    @Test
    public void insert() {
        Long templateId = 10L;
        String name = "哈哈哈";
        String description = "H";
        Attribute attribute = new Attribute();
        attribute.setTemplateId(templateId);
        attribute.setName(name);
        attribute.setDescription(description);
        int rows = attributeMapper.insert(attribute);
        log.info("插入成功受影响的行数：{}", rows);
    }

    @Test
    public void deleteById() {
        Long id = 2L;
        int rows = attributeMapper.deleteById(id);
        log.info("删除成功，受影响的行数：{}", rows);
    }

    @Test
    public void deleteByIds() {
        int rows = attributeMapper.deleteByIds(11L, 12L, 13L);
        log.info("批量删除成功，受影响的行数：{}", rows);
    }
}
