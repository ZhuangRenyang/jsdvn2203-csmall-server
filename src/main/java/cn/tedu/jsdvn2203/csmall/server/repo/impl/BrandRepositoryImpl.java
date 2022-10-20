package cn.tedu.jsdvn2203.csmall.server.repo.impl;

import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Repository;

@Repository
@Scope("singleton")//@Scope("prototype")//多
public class BrandRepositoryImpl implements IBrandRepository {
}
