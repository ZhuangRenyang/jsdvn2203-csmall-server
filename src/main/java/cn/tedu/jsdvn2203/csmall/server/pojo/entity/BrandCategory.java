package cn.tedu.jsdvn2203.csmall.server.pojo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class BrandCategory implements Serializable {

    private Long id;
    private Long brandId;
    private Long categoryId;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
