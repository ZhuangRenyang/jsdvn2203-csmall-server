package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.repo.IAlbumRepository;
import cn.tedu.jsdvn2203.csmall.server.service.IAlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AlbumServiceImpl implements IAlbumService {

    @Autowired
   public IAlbumRepository albumRepository;

}
