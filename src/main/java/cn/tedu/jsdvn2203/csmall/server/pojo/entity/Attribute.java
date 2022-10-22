package cn.tedu.jsdvn2203.csmall.server.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class Attribute implements Serializable {
    private Long id;
    private Long templateId;
    private String name;
    private String description;
    private Integer type;
    private Integer inputType;
    private String valueList;
    private Integer sort;
    private String unit;
    private Integer isAllowCustomize;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
