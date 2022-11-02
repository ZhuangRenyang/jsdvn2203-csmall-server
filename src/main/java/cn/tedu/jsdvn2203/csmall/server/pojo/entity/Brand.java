package cn.tedu.jsdvn2203.csmall.server.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 品牌实体类
 */
@Data
public class Brand implements Serializable {
    private Long id;//记录id

    private String name;//品牌名称

    private String pinyin;//品牌名称的拼音

    private String logo;//品牌logo的URL

    private String description;//品牌简介

    private Integer sort;//自定义排序序号

    private String keywords;//关键词列表，各关键词使用英文的逗号分隔

    private Integer sales;//销量（冗余）

    private Integer productCount;//商品种类数量总和（冗余）

    private Integer commentCount;//买家评论数量总和（冗余）

    private Integer positiveCommentCount;//买家好评数量总和（冗余）

    private Integer enable;//是否启用，1=启用，0=未启用

    private LocalDateTime gmtCreate;//创建时间

    private LocalDateTime gmtModified;//最后修改时间
}
