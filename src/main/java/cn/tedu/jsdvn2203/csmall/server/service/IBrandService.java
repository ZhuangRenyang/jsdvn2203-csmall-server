package cn.tedu.jsdvn2203.csmall.server.service;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandDeleteDTO;

public interface IBrandService {
   /**
    * 创建品牌
    * @param brandAddNewDTO 品牌数据
    */
   void addNew(BrandAddNewDTO brandAddNewDTO);

   void delete(BrandDeleteDTO brandDeleteDTO);
}
