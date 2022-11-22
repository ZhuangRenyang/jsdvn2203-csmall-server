package cn.tedu.jsdvn2203.csmall.server.aspect;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

//编写AOP配置的类必须保存在Spring容器中才能使配置生效
@Component
@Aspect  //当前类是一个编写切面的类
@Slf4j
public class DemoAspect {
    // 定义切面 - 指定方法
    @Pointcut("execution(public* cn.tedu.jsdvn2203.csmall.server.controller.BrandController.list(..))")
    // 注解后必须跟一个方法的声明 - 这个方法为了单纯的定义这个切面的名称，不需要写任何代码
    public void pointCut() {
    }

    // 织入内容
    // 前置advice
    @Before("pointCut()")
    public void before() {
        log.debug("前置advice执行了...");
    }

    // 后置advice
    @After("pointCut()")
    public void after() {
        log.debug("后置advice执行...");
    }

    // 异常advice(只有目标方法发生异常时才会执行)
    @AfterThrowing("pointCut()")
    public void throwing() {
        log.debug("方法发生异常....");
    }

    // 环绕通知要想正常运行，必须设置方法参数，类型为ProceedingJoinPoint是JoinPoint的子接口，拥有更多的方法
    // 这个方法必须要有返回值，调用切面的方法可能会有返回值，环绕advice不返回这个值，调用者就接收不到这个值
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint)throws Throwable{
        log.debug("环绕advice,运行之前...");
        //ProceedingJoinPoint类型参数具有调用切面方法的功能
        Object object = joinPoint.proceed();
        log.debug("环绕advice,运行之后!!!");
        return object;
    }
}
