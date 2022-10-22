package cn.tedu.jsdvn2203.csmall.server.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Spu implements Serializable {
    private Long id;
    private String name;
    private String typeNumber;
    private String title;
    private String description;
    private Double listPrice;
    private Integer stock;
    private Integer stockThreshold;
    private String unit;
    private Long brandId;
    private String brandName;
    private Long categoryId;
    private String categoryName;
    private Long attributeTemplateId;
    private Long albumId;
    private String pictures;
    private String keywords;
    private String tags;
    private Integer sales;
    private Integer commentCount;
    private Integer positiveCommentCount;
    private Integer sort;
    private Integer isDeleted;
    private Integer isPublished;
    private Integer isNewArrival;
    private Integer isRecommend;
    private Integer isChecked;
    private String checkUser;
    private LocalDateTime gmtCheck;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
