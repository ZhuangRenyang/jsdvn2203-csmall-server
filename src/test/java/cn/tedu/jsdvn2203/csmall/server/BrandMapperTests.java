package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.mapper.BrandMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class BrandMapperTests {
    @Autowired
    BrandMapper brandMapper;
    @Test
    public void testInsert(){
        Brand brand = new Brand();
        brand.setName("虾米");
        int rows = brandMapper.insert(brand);
        Long id = brand.getId();
        System.out.println("插入成功,受影响的行数为:"+rows+",id值为:"+id);
    }
}
