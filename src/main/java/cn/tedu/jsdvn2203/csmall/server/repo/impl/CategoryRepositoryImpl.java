package cn.tedu.jsdvn2203.csmall.server.repo.impl;

import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;
import cn.tedu.jsdvn2203.csmall.server.repo.ICategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Repository
public class CategoryRepositoryImpl implements ICategoryRepository {
    public CategoryRepositoryImpl() {
        log.info("创建控制器访问对象:CategoryRepositoryImpl");
    }

    @Autowired
    private RedisTemplate<String, Serializable> redisTemplate;


    @Override
    public void put(CategoryDetailVO categoryDetailVO) {
        String key = KEY_PREFIX_CATEGORY_ITEM + categoryDetailVO.getId();
        redisTemplate.opsForValue().set(key, categoryDetailVO);
    }

    @Override
    public CategoryDetailVO get(Long id) {
        String key = KEY_PREFIX_CATEGORY_ITEM + id;
        CategoryDetailVO categoryDetailVO = null;
        Serializable serializable = redisTemplate.opsForValue().get(key);
        if (serializable != null) {
            if (serializable instanceof CategoryDetailVO) {
                categoryDetailVO = (CategoryDetailVO) serializable;
            }
        }
        return categoryDetailVO;
    }

    @Override
    public void deleteItem(Long id) {
        String key = KEY_PREFIX_CATEGORY_ITEM + id;
        redisTemplate.delete(key);
    }

    @Override
    public void putList(List<CategoryListItemVO> list) {
        log.debug("向redis中写入类别列表数据:{}", list);
        for (CategoryListItemVO categoryListItemVO : list) {
            redisTemplate.opsForList().rightPush(KEY_CATEGORY_LIST,categoryListItemVO);
        }
        log.debug("成功");
    }

    @Override
    public List<CategoryListItemVO> getList() {
        log.debug("从redis中读取品牌列表数据...");
        List<Serializable> list = redisTemplate.opsForList().range(KEY_CATEGORY_LIST,0,-1);
        List<CategoryListItemVO> category = new ArrayList<>();
        for (Serializable serializable:list) {
            category.add((CategoryListItemVO) serializable);
        }
        return category;
    }

    @Override
    public void deleteList() {
        redisTemplate.delete(KEY_CATEGORY_LIST);
    }


}
