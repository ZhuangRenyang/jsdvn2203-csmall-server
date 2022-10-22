package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
/**
 * 新增商品DTO类
 *  添加set&get / equals&hashcode / toString 方法
 */
@Data
public class BrandAddNewDTO implements Serializable {
    private String name;
    private String pinyin;
    private String logo;
    private Long categoryId;
    private String description;
    private String keywords;
    private String sort;
}
