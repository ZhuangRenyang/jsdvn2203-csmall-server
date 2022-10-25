package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Objects;
/**
 * 新增商品DTO类
 *  添加set&get / equals&hashcode / toString 方法
 */
@Data
public class BrandAddNewDTO implements Serializable {
    @ApiModelProperty(value = "品牌名称",required = true,example ="华为")
    private String name;
    @ApiModelProperty(value = "品牌拼音",required = true,example = "huawei")
    private String pinyin;
    @ApiModelProperty(value = "品牌logo",required = true,example = "http://p1.music/109.jpg")
    private String logo;
    @ApiModelProperty(value = "类别id",example = "1")
    private Long categoryId;
    @ApiModelProperty(value = "品牌简介",example = "专注技术几十年")
    private String description;
    @ApiModelProperty(value = "关键词列表(关键词之间逗号分割)",example = "华为,5G,meta")
    private String keywords;
    @ApiModelProperty(value = "自定义排序符号",example = "110")
    private String sort;
}
