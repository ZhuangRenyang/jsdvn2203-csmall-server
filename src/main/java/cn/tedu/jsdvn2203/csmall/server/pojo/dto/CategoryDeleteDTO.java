package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class CategoryDeleteDTO implements Serializable {
    @ApiModelProperty(value = "类别id", required = true, example = "10")
    private Long id;
}
