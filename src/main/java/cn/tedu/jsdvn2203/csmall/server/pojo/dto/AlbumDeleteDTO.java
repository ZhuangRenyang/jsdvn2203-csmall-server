package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AlbumDeleteDTO implements Serializable {
    @ApiModelProperty(value = "相册id",required = true,example = "3")
    private Long id;
}
