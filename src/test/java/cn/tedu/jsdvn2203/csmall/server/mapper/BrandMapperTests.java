package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class BrandMapperTests {
    @Autowired
    BrandMapper brandMapper;
    @Test
    public void testInsert(){
        String name = "虾米";
        String pinyin = "xiaomi";
        String logo = "xiaomi";
        String description = "小米";
        String keywords = "小米";
        int sort = 12;
        int sales = 123;
        int productCount = 0;
        Brand brand = new Brand();
        brand.setName(name);
        brand.setPinyin(pinyin);
        brand.setLogo(logo);
        brand.setDescription(description);
        brand.setKeywords(keywords);
        brand.setSort(sort);
        brand.setSales(sales);
        brand.setProductCount(productCount);
        int rows = brandMapper.insert(brand);
        Long id = brand.getId();
        log.info("插入成功,受影响的行数为:{},id值为:{}",rows,id);
    }
    @Test
    public void testDeleteById(){
        Long id = 1L;
        int rows = brandMapper.deleteById(id);
        log.info("删除完成，受影响的行数={}",rows);
    }
    @Test
    public void testDeleteByIds(){
       int rows = brandMapper.deleteByIds(3L,4L,8L);
        log.info("删除完成，受影响的行数={}",rows);
    }
    @Test
    public void testUpdateNameById(){
        Long id = 3L;
        String name = "白萝卜";
        int rows = brandMapper.updateNameById(id, name);
        log.info("修改品牌名称完成，受影响的行数={}",rows);
    }

    @Test
    public void testUpdateById(){
        Long id = 9L;
        String name = "小米";
        String pinyin = "xiaomi";
        Brand brand = new Brand();
        brand.setId(id);
        brand.setName(name);
        brand.setPinyin(pinyin);
        int rows = brandMapper.updateById(brand);
        log.info("修改品牌名称完成，受影响的行数={}",rows);
    }

    @Test
    public void testCount(){
        int count = brandMapper.count();
        log.info("统计品牌数量完成,统计结果 ={}",count);
    }
    
    @Test
    public void testGetById(){
        Long id = 13L;
        BrandDetailVO brandDetailVO = brandMapper.getById(id);
        log.info("查询的结果:{}",brandDetailVO);
    }

    @Test
    public void testListBrand() {
        List<BrandListItemVO> list = brandMapper.list();
        log.info("查询的结果:{}", list.size());
        for (BrandListItemVO itemVO : list) {
            log.info("{}",itemVO);
        }
    }

    @Test
    public void testLogLeve(){
        log.trace("这是trace级别的日志...");
        log.debug("这是debug级别的日志...");
        log.info("这是info级别的日志...");
        log.warn("这是warn级别的日志...");
        log.error("这是error级别的日志...");
    }
}