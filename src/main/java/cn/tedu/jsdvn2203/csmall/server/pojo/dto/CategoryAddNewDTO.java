package cn.tedu.jsdvn2203.csmall.server.pojo.dto;

import java.io.Serializable;
import java.util.Objects;

public class CategoryAddNewDTO implements Serializable {
    private String superiorCategory;
    private String categoryName;
    private Integer sort;
    private String url;
    private String keyword;

    public String getSuperiorCategory() {
        return superiorCategory;
    }

    public void setSuperiorCategory(String superiorCategory) {
        this.superiorCategory = superiorCategory;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CategoryAddNewDTO that = (CategoryAddNewDTO) o;
        return Objects.equals(superiorCategory, that.superiorCategory) && Objects.equals(categoryName, that.categoryName) && Objects.equals(sort, that.sort) && Objects.equals(url, that.url) && Objects.equals(keyword, that.keyword);
    }

    @Override
    public int hashCode() {
        return Objects.hash(superiorCategory, categoryName, sort, url, keyword);
    }

    @Override
    public String toString() {
        return "CategoryAddNewDTO{" +
                "superiorCategory='" + superiorCategory + '\'' +
                ", categoryName='" + categoryName + '\'' +
                ", sort=" + sort +
                ", url='" + url + '\'' +
                ", keyword='" + keyword + '\'' +
                '}';
    }
}
