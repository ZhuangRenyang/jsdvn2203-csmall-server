package cn.tedu.jsdvn2203.csmall.server.pojo.entity;

import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

@Data
public class CategoryAttributeTemplate implements Serializable {
    private Long id;
    private Long categoryId;
    private Long attributeTemplateId;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
