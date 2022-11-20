package cn.tedu.jsdvn2203.csmall.server.repo;

import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;

import java.util.List;

public interface IBrandRepository {

    String KEY_PREFIX_BRAND_ITEM = "brand:item:";

    String KEY_BRAND_LIST = "brand:list";

    // 存数据
    void put(BrandDetailVO brandDetailVO);

    // 取数据
    BrandDetailVO get(Long id);

    // 删数据
    void deleteItem(Long id);

    void putList(List<BrandListItemVO> list);
    List<BrandListItemVO> getList();
    void deleteList();
}
