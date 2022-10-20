package cn.tedu.jsdvn2203.csmall.server.service.impl;

import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import cn.tedu.jsdvn2203.csmall.server.service.IBrandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BrandServiceImpl implements IBrandService {

    @Autowired
    public IBrandRepository brandRepository;
}
