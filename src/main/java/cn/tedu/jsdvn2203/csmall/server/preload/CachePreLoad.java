package cn.tedu.jsdvn2203.csmall.server.preload;

import cn.tedu.jsdvn2203.csmall.server.mapper.BrandMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Brand;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
//@Component
public class CachePreLoad implements ApplicationRunner {

@Autowired
private BrandMapper brandMapper;

@Autowired
private IBrandRepository brandRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.debug("执行CachePreLoad.run()方法");

        // 将redis中品牌列表清除
        brandRepository.deleteList();
        //从mysql中读取品牌列表
        List<BrandListItemVO> brands = brandMapper.list();
        //将品牌列表写入到redis
        brandRepository.putList(brands);
    }
}
