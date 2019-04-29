package com.zhaomlb.club.bootsp.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志记录
 */
@Aspect
@Component
public class AopLogslf4j {
    private Logger logger = LoggerFactory.getLogger(AopLogslf4j.class);

    @Pointcut("execution(* com.zhaomlb.club.bootsp.controller..*(..))")
    public void alllog() {
    }

    @Before(value = "alllog()")
    public void doBefore(JoinPoint joinPoint) {

        StringBuilder str = new StringBuilder();
        str.append("类:").append(joinPoint.getSignature().getName());
        str.append("参数:").append(joinPoint.getArgs().toString());
        System.out.print(str.toString());
        logger.error(str.toString());
    }

}
