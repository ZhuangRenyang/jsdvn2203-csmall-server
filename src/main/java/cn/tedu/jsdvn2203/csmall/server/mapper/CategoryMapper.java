package cn.tedu.jsdvn2203.csmall.server.mapper;

import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Category;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryDetailVO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryMapper {

    int insert(Category category);

    int deleteById(Long id);

    int deleteByIds(Long... id);

    int countByName(String name);

    int countById(Long id);
    /**
     * 根据id查询类别详情
     * @param id 类别id
     * @return 类别详情
     */
    CategoryDetailVO getById(Long id);

    List<CategoryListItemVO> list();

    int updateCategory(Category category);
}
