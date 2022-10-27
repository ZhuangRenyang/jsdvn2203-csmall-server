package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.mapper.AlbumMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumDeleteDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Album;
import cn.tedu.jsdvn2203.csmall.server.repo.IAlbumRepository;
import cn.tedu.jsdvn2203.csmall.server.service.IAlbumService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
   public IAlbumRepository albumRepository;

    @Autowired
    AlbumMapper albumMapper;
    @Override
    public void addNew(AlbumAddNewDTO albumAddNewDTO){
        //创建相册实体
        Album album = new Album();
        BeanUtils.copyProperties(albumAddNewDTO,album);
        int rows = albumMapper.insert(album);
        log.info("插入成功,受影响的行数为:{}",rows);
    }

    @Override
    public void delete(AlbumDeleteDTO albumDeleteDTO) {
        Album album = new Album();
        BeanUtils.copyProperties(albumDeleteDTO,album);
        int rows = albumMapper.deleteById(album.getId());
        log.info("删除成功,受影响的行数为:{}",rows);
    }
}
