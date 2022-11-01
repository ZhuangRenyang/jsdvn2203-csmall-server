package cn.tedu.jsdvn2203.csmall.server.pojo.vo;

import lombok.Data;

import java.io.Serializable;
@Data
public class CategoryListItemVO implements Serializable {

    private Long id;
    private String name;
    private Long parentId;
    private Integer depth;
    private String keywords;
    private Integer sort;
    private String icon;
    private Integer enable;
    private Integer isParent;
    private Integer isDisplay;
}
