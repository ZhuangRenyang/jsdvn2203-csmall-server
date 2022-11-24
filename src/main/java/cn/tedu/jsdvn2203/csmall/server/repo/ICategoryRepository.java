package cn.tedu.jsdvn2203.csmall.server.repo;

import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;

import java.util.List;

//接口不能实例化, 测试：测试类方法会报错。
//@Repository
public interface ICategoryRepository {

    String KEY_PREFIX_CATEGORY_ITEM = "category:item:";

    String KEY_CATEGORY_LIST = "category:list";

    // 存数据
    void put(CategoryDetailVO categoryDetailVO);

    // 取数据
    CategoryDetailVO get(Long id);

    // 删数据
    void deleteItem(Long id);

    void putList(List<CategoryListItemVO> list);

    List<CategoryListItemVO> getList();

    void deleteList();
}
