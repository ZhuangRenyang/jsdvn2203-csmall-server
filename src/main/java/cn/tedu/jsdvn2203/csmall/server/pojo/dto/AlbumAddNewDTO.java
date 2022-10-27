package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class AlbumAddNewDTO implements Serializable {
    @ApiModelProperty(value = "相册名称" , required = true , example = "相册")
    private String name;
    @ApiModelProperty(value = "相册简介" , required = true ,example = "这是我的相册")
    private String description;
}
