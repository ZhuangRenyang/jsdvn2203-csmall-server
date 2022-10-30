package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.exception.ServiceException;
import cn.tedu.jsdvn2203.csmall.server.mapper.AlbumMapper;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumAddNewDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.dto.AlbumDeleteDTO;
import cn.tedu.jsdvn2203.csmall.server.pojo.entity.Album;
import cn.tedu.jsdvn2203.csmall.server.repo.IAlbumRepository;
import cn.tedu.jsdvn2203.csmall.server.service.IAlbumService;
import cn.tedu.jsdvn2203.csmall.server.web.ServiceCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
   public IAlbumRepository albumRepository;//Repo响应接口

    @Autowired
    AlbumMapper albumMapper;//Mapper接口
    @Override
    public void addNew(AlbumAddNewDTO albumAddNewDTO){
        //检查相册名称是否被占用
        String name = albumAddNewDTO.getName();//获取相册名称
        int count = albumMapper.countByName(name);//检查是否有该名称
        if (count > 0){
            String message = "添加失败相册名称["+name+"]已存在";
            log.error(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);//错误：冲突 - 重复数据
        }
        Album album = new Album(); //创建相册实体
        BeanUtils.copyProperties(albumAddNewDTO,album);//类型转换赋值
        int rows = albumMapper.insert(album);//执行插入
        log.info("插入成功,受影响的行数为:{}",rows);
    }

    @Override
    public void delete(AlbumDeleteDTO albumDeleteDTO) {
        //检查相册id是否存在
        Long id = albumDeleteDTO.getId();//获取相册id
        int count = albumMapper.countById(id);//检查是否有该id
        if (count == 0){
            String message = "删除失败，相册id["+id+"]不存在";
            log.error(message);
            throw new ServiceException(ServiceCode.ERR_CONFLICT,message);//错误：冲突 - 重复数据
        }
        Album album = new Album(); //创建相册实体
        BeanUtils.copyProperties(albumDeleteDTO,album);//类型转换赋值
        int rows = albumMapper.deleteById(album.getId());//执行删除
        log.info("删除成功,受影响的行数为:{}",rows);
    }
}
