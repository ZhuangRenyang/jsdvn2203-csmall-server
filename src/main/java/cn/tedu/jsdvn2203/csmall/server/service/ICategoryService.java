package cn.tedu.jsdvn2203.csmall.server.service;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.CategoryDeleteDTO;

public interface ICategoryService {

    void addNew(CategoryAddNewDTO categoryAddNewDTO);

    void delete(CategoryDeleteDTO categoryDeleteDTO);
}
