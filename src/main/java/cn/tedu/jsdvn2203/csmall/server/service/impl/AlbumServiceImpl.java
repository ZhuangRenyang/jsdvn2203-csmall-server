package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
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
        String name = albumAddNewDTO.getName();
        int count = albumMapper.countByName(name);
        if (count > 0){
            String message = "添加失败相册名称["+name+"]已存在";
            log.error(message);
            throw new ServiceException(message);
        }

        //创建相册实体
        Album album = new Album();
        BeanUtils.copyProperties(albumAddNewDTO,album);
        int rows = albumMapper.insert(album);
        log.info("插入成功,受影响的行数为:{}",rows);
    }

    @Override
    public void delete(AlbumDeleteDTO albumDeleteDTO) {
        Long id = albumDeleteDTO.getId();
        int count = albumMapper.countById(id);
        if (count == 0){
            String message = "删除失败，相册id["+id+"]不存在";
            log.error(message);
            throw new ServiceException(message);
        }

        Album album = new Album();
        BeanUtils.copyProperties(albumDeleteDTO,album);
        int rows = albumMapper.deleteById(album.getId());
        log.info("删除成功,受影响的行数为:{}",rows);
    }
}
