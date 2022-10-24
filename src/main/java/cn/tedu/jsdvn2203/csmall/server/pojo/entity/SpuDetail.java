package cn.tedu.jsdvn2203.csmall.server.pojo.entity;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class SpuDetail {
    private Long id;
    private Long spuId;
    private String detail;
    private LocalDateTime gmtCreate;
    private LocalDateTime gmtModified;
}
