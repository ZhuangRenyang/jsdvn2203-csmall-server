package cn.tedu.jsdvn2203.csmall.server.pojo.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Objects;

/**
 * 品牌实体类
 */
public class Brand implements Serializable {
    private Long id;
    private String name;
    private String pinyin;
    private String logo;
    private String description;
    private Integer sort;
    private String keywords;
    private Integer sales;
    private Integer productCount;
    private Integer commentCount;
    private Integer positiveCommentCount;
    private Integer enable;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPinyin() {
        return pinyin;
    }

    public void setPinyin(String pinyin) {
        this.pinyin = pinyin;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public Integer getProductCount() {
        return productCount;
    }

    public void setProductCount(Integer productCount) {
        this.productCount = productCount;
    }

    public Integer getCommentCount() {
        return commentCount;
    }

    public void setCommentCount(Integer commentCount) {
        this.commentCount = commentCount;
    }

    public Integer getPositiveCommentCount() {
        return positiveCommentCount;
    }

    public void setPositiveCommentCount(Integer positiveCommentCount) {
        this.positiveCommentCount = positiveCommentCount;
    }

    public Integer getEnable() {
        return enable;
    }

    public void setEnable(Integer enable) {
        this.enable = enable;
    }

    public LocalDateTime getGmtCreate() {
        return gmtCreate;
    }

    public void setGmtCreate(LocalDateTime gmtCreate) {
        this.gmtCreate = gmtCreate;
    }

    public LocalDateTime getGmtModified() {
        return gmtModified;
    }

    public void setGmtModified(LocalDateTime gmtModified) {
        this.gmtModified = gmtModified;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Brand brand = (Brand) o;
        return Objects.equals(id, brand.id) && Objects.equals(name, brand.name) && Objects.equals(pinyin, brand.pinyin) && Objects.equals(logo, brand.logo) && Objects.equals(description, brand.description) && Objects.equals(sort, brand.sort) && Objects.equals(keywords, brand.keywords) && Objects.equals(sales, brand.sales) && Objects.equals(productCount, brand.productCount) && Objects.equals(commentCount, brand.commentCount) && Objects.equals(positiveCommentCount, brand.positiveCommentCount) && Objects.equals(enable, brand.enable) && Objects.equals(gmtCreate, brand.gmtCreate) && Objects.equals(gmtModified, brand.gmtModified);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pinyin, logo, description, sort, keywords, sales, productCount, commentCount, positiveCommentCount, enable, gmtCreate, gmtModified);
    }

    @Override
    public String toString() {
        return "Brand{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pinyin='" + pinyin + '\'' +
                ", logo='" + logo + '\'' +
                ", description='" + description + '\'' +
                ", sort=" + sort +
                ", keywords='" + keywords + '\'' +
                ", sales=" + sales +
                ", productCount=" + productCount +
                ", commentCount=" + commentCount +
                ", positiveCommentCount=" + positiveCommentCount +
                ", enable=" + enable +
                ", gmtCreate=" + gmtCreate +
                ", gmtModified=" + gmtModified +
                '}';
    }
}
