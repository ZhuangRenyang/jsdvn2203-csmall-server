package cn.tedu.jsdvn2203.csmall.server.repo.impl;

import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;
@Slf4j
@Repository
@Scope("singleton")//@Scope("prototype")//多
public class BrandRepositoryImpl implements IBrandRepository {
}
