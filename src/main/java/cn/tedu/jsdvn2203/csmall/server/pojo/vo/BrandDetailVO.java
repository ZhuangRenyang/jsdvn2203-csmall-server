package cn.tedu.jsdvn2203.csmall.server.pojo.vo;

import lombok.Data;

import java.io.Serializable;

@Data
public class BrandDetailVO implements Serializable {
    private Long id;
    private String name;
    private String pinyin;
    private String logo;
    private String description;
    private Integer sort;
    private String keywords;
    private Integer sales;
    private Integer productCount;
    private Integer commentCount;
    private Integer positiveCommentCount;
    private Integer enable;

}
