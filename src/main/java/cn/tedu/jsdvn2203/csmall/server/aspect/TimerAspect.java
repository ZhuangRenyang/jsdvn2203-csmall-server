package cn.tedu.jsdvn2203.csmall.server.aspect;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * 统计各Service方法的执行耗时的切面类
 *
 * System.currentTimeMills()
 */
@Slf4j
@Component
@Aspect
public class TimerAspect {
    @Pointcut("execution(public* cn.tedu.jsdvn2203.csmall.server.controller.BrandController.list(..))")
    public void pointCut() {
    }
    @Before("pointCut()")
    public void before() {
       long startTime1 =System.currentTimeMillis();
        log.debug("前置advice执行了...");
        log.debug("程序开始时间为："+startTime1+"毫秒");
    }
    @After("pointCut()")
    public void after() {
        long endTime2=System.currentTimeMillis();
        log.debug("后置advice执行...");
        log.debug("程序结束时间为："+endTime2+"毫秒");
    }

    @Around("execution(* cn.tedu.jsdvn2203.csmall.server.service.impl.*.*())")
    public Object around(ProceedingJoinPoint joinPoint)throws Throwable{

        Long start = System.currentTimeMillis();
        Object object = joinPoint.proceed();
        Long end = System.currentTimeMillis();
        log.debug("当前切面匹配到的组件类:{}",joinPoint.getTarget());
        log.debug("当前切面匹配的方法:{}",joinPoint.getSignature());
        log.debug("当前切面匹配的参数列表:{}",joinPoint.getArgs());
       log.debug("当前业务方法的执行耗时:{}ms",end-start);
        return object;
    }
}
