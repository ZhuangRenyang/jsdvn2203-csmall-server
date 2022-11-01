package cn.tedu.jsdvn2203.csmall.server.service;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.BrandDeleteDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.vo.BrandListItemVO;

import java.util.List;

public interface IBrandService {
   /**
    * 创建品牌
    * @param brandAddNewDTO 品牌数据
    */
   void addNew(BrandAddNewDTO brandAddNewDTO);

   /**
    * 品牌列表
    * @return 品牌列表
    */
   List<BrandListItemVO> list();

   void delete(BrandDeleteDTO brandDeleteDTO);
}
