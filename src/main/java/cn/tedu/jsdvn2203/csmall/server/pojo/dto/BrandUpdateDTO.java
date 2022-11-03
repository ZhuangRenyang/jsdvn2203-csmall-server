package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

import static cn.tedu.jsdvn2203.csmall.server.validation.BrandValidationConst.MESSAGE_PINYIN;
import static cn.tedu.jsdvn2203.csmall.server.validation.BrandValidationConst.REGEXP_PINYIN;

@Data
public class BrandUpdateDTO implements Serializable {
    /**
     * 记录id
     */
    private Long id;
    /**
     * 品牌名称
     */

    @ApiModelProperty(value = "品牌名称",required = true,example ="华为")
//    @NotNull(message = "请填写有效的品牌名称-Null")
//    @NotEmpty(message = "请填写有效的品牌名称-Empty")
    @NotBlank(message = "请填写有效的品牌名称-NotBlank")
    private String name;
    /**
     * 品牌名称的拼音
     */
    @ApiModelProperty(value = "品牌拼音",required = true,example = "huawei")
    @NotNull(message = "请填写有效的品牌拼音")
    @Pattern(regexp = REGEXP_PINYIN, message = MESSAGE_PINYIN)
    private String pinyin;
    /**
     * 品牌logo的URL
     */
    private String logo;
    /**
     * 品牌简介
     */
    private String description;
    /**
     * 关键词列表，各关键词使用英文的逗号分隔
     */
    private String keywords;
    /**
     * 自定义排序序号
     */
    private Integer sort;
    /**
     * 销量（冗余）
     */
    private Integer sales;
    /**
     * 商品种类数量总和（冗余）
     */
    private Integer productCount;
    /**
     * 买家评论数量总和（冗余）
     */
    private Integer commentCount;
    /**
     * 买家好评数量总和（冗余）
     */
    private Integer positiveCommentCount;
    /**
     * 是否启用，1=启用，0=未启用
     */
    private Integer enable;
}
