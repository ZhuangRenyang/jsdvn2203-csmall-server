package cn.tedu.jsdvn2203.csmall.server.mapper;


import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Category;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@Slf4j
@SpringBootTest
public class CategoryMapperTests {

    @Autowired
    CategoryMapper categoryMapper;

    @Test
    public void testInsert() {
        String name = "嘿嘿嘿";
        Long parentId = 10L;
        Category category = new Category();
        category.setName(name);
        category.setParentId(parentId);
        int rows = categoryMapper.insert(category);
        log.info("插入成功,受影响的行数:{}", rows);
    }

    @Test
    public void testDeleteById(){
        Long id = 14L;
        int rows = categoryMapper.deleteById(id);
        log.info("删除成功,受影响的行数:{}",rows);
    }

    @Test
    public void testDeleteByIds(){
        int rows = categoryMapper.deleteByIds(10L,11L,12L);
        log.info("批量删除成功,受影响的行数:{}",rows);
    }
}
