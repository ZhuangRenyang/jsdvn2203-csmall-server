package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Range;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

//分类管理
@Data
public class CategoryAddNewDTO implements Serializable {
    @ApiModelProperty(value = "类别名称", required = true, example = "家电数码")
    @NotBlank(message = "请填写有效的品牌名称-NotBlank")
    private String name;
    @ApiModelProperty(value = "父级类别id", required = true, example = "2")
    private Long parentId;
    @ApiModelProperty(value = "深度", required = true, example = "1")
    private Integer depth;
    @ApiModelProperty(value = "关键词(关键词之间逗号分割)", example = "手机,电话")
    private String keywords;
    @ApiModelProperty(value = "自定义排序序号", example = "0")
    @Range(min = 0,max = 99,message = "自定义排序值必须在0~99之间")
    private Integer sort;
    @ApiModelProperty(value = "图片路径", example = "http://mi/12por")
    private String icon;
    @ApiModelProperty(value = "是否启用", example = "1")
    private Integer enable;
}
