package cn.tedu.jsdvn2203.csmall.server.service;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.CategoryListItemVO;

import java.util.List;

public interface ICategoryService {

    void insert(CategoryAddNewDTO categoryAddNewDTO);

    /**
     * 分类列表
     * @return 分类列表
     */
    List<CategoryListItemVO> list();

//    void delete(CategoryDeleteDTO categoryDeleteDTO);

    void deleteById(Long id);

    void updateById(Long id, String name);

}
