package cn.tedu.jsdvn2203.csmall.server.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Sku implements Serializable {
    private Long id;
    private Long spuId;
    private String title;
    private String barCode;
    private Long attributeTemplateId;
    private String specifications;
    private Long albumId;
    private String pictures;
    private Double price;
    private Integer stock;
    private Integer stockThreshold;
    private Integer sales;
    private Integer commentCount;
    private Integer positiveCommentCount;
    private Integer sort;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
