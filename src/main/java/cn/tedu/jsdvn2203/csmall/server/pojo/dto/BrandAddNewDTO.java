package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.io.Serializable;
import static cn.tedu.jsdvn2203.csmall.server.validation.BrandValidationConst.*;
/**
 * 新增商品DTO类
 *  添加set&get / equals&hashcode / toString 方法
 */
@Data
public class BrandAddNewDTO implements Serializable {
    @ApiModelProperty(value = "品牌名称",required = true,example ="华为")
//    @NotNull(message = "请填写有效的品牌名称-Null")
//    @NotEmpty(message = "请填写有效的品牌名称-Empty")
    @NotBlank(message = "请填写有效的品牌名称-NotBlank")
    private String name;

    @ApiModelProperty(value = "品牌拼音",required = true,example = "huawei")
    @NotNull(message = "请填写有效的品牌拼音")
    @Pattern(regexp = REGEXP_PINYIN, message = MESSAGE_PINYIN)
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
    @Range(min = 0,max = 99,message = "自定义排序值必须在0~99之间")
    private String sort;
}
