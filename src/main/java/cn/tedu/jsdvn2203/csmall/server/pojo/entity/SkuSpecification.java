package cn.tedu.jsdvn2203.csmall.server.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class SkuSpecification implements Serializable {

    private Long id;
    private Long skuId;
    private Long attributeId;
    private String attributeName;
    private String attributeValue;
    private String unit;
    private Integer sort;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
