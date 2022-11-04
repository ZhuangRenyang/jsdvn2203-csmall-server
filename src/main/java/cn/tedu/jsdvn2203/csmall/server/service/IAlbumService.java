package cn.tedu.jsdvn2203.csmall.server.service;

import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumAddNewDTO;

public interface IAlbumService {

    /**
     * 添加相册
     * @param albumAddNewDTO 需要添加的相册数据
     */
    void addNew(AlbumAddNewDTO albumAddNewDTO);

}
