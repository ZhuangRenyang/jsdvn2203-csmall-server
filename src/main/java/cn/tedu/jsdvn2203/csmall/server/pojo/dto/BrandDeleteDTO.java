package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
@Data
public class BrandDeleteDTO implements Serializable {
    @ApiModelProperty(value = "类别ID",required = true,example = "1")
    private Long id;

}
