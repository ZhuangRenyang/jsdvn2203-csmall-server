package cn.tedu.jsdvn2203.csmall.server.schedule;

import cn.tedu.jsdvn2203.csmall.server.mapper.BrandMapper;
import cn.tedu.jsdvn2203.csmall.server.mapper.CategoryMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import cn.tedu.jsdvn2203.csmall.server.repo.ICategoryRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import java.util.List;

@Slf4j
@Component
public class CacheSchedule {

    @Autowired
    private BrandMapper brandMapper;

    @Resource(name = "categoryMapper")
    private CategoryMapper categoryMapper;


    @Autowired
    private IBrandRepository brandRepository;

    @Resource(name = "categoryRepositoryImpl")
    private ICategoryRepository categoryRepository;
    /**
     * 计划任务，默认不开启，需要配置类进行配置
     */
    // cron = "秒 分 时 日 月 周"
    // cron = "56 23 18 ? * MON" 表示:每个月的周一(无视几号)的18:23:56将执行此任务
    // @Scheduled(cron = "56 23 18 ? * MON")
    @Scheduled(fixedRate = 1 * 60 * 60 * 1000)
    public void updateCache() {
        log.debug("执行计划任务，更新缓存中的品牌列表...");

        // 将redis中品牌列表清除
        brandRepository.deleteList();
        //从mysql中读取品牌列表
        List<BrandListItemVO> brands = brandMapper.list();
        //将品牌列表写入到redis
        brandRepository.putList(brands);


        // 将redis中类别列表清除
        categoryRepository.deleteList();
         //从mysql中读取类别列表
        List<CategoryListItemVO> category = categoryMapper.list();
        //将类别列表写入到redis
        categoryRepository.putList(category);
    }
}
