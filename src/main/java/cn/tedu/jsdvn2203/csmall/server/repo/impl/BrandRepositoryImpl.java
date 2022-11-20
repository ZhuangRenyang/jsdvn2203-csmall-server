package cn.tedu.jsdvn2203.csmall.server.repo.impl;

import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
//@Scope("singleton")//@Scope("prototype")//多
public class BrandRepositoryImpl implements IBrandRepository {

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;

    @Override
    public void put(BrandDetailVO brandDetailVO) {
        String key = KEY_PREFIX_BRAND_ITEM + brandDetailVO.getId();
        redisTemplate.opsForValue().set(key, brandDetailVO);
    }

    @Override
    public BrandDetailVO get(Long id) {
        String key = KEY_PREFIX_BRAND_ITEM + id;
        BrandDetailVO brandDetailVO = null;
        Serializable serializable = redisTemplate.opsForValue().get(key);
        if (serializable != null) {
            if (serializable instanceof BrandDetailVO) {
                brandDetailVO = (BrandDetailVO) serializable;
            }
        }
        return brandDetailVO;
    }

    @Override
    public void deleteItem(Long id) {
        String key = KEY_PREFIX_BRAND_ITEM+id;
        redisTemplate.delete(key);
    }

    @Override
    public void putList(List<BrandListItemVO> list) {
        log.debug("向redis中写入品牌列表数据:{}",list);
        for (BrandListItemVO brandListItemVO : list) {
           redisTemplate.opsForList().rightPush(KEY_BRAND_LIST,brandListItemVO);
        }
        log.debug("成功");

    }

    @Override
    public List<BrandListItemVO> getList() {
        log.debug("从redis中读取品牌列表数据...");
        List<Serializable> list = redisTemplate.opsForList().range(KEY_BRAND_LIST,0,-1);
        List<BrandListItemVO> brands = new ArrayList<>();
        for (Serializable serializable :list) {
            brands.add((BrandListItemVO) serializable);
        }
        return brands;
    }

    @Override
    public void deleteList() {
        redisTemplate.delete(KEY_BRAND_LIST);
    }
}
