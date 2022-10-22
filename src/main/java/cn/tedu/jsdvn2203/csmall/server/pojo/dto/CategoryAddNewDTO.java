package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Objects;

@Data
public class CategoryAddNewDTO implements Serializable {
    private String superiorCategory;
    private String categoryName;
    private Integer sort;
    private String url;
    private String keyword;
}
