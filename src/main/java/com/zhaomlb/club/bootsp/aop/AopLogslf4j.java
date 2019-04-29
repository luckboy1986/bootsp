package com.zhaomlb.club.bootsp.aop;

import javassist.*;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * 日志记录
 */
@Aspect
@Component
public class AopLogslf4j {
    private final Logger logger = LoggerFactory.getLogger(AopLogslf4j.class);

    @Pointcut("execution(* com.zhaomlb.club.bootsp.controller..*(..))")
    public void alllog() {
    }

    @Before(value = "alllog()")
    public void doBefore(JoinPoint joinPoint) {

        StringBuilder str = new StringBuilder();
        str.append("类:").append(joinPoint.getTarget().getClass().getName());
        str.append("\r\n");
        str.append("方法名:").append(joinPoint.getSignature().getName());
        str.append("\r\n");
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();

        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            str.append("参数类型:").append(args[i].getClass().getName());
            str.append("参数名称:").append(parameterNames[i]);
            str.append("参数值:").append(args[i]);
            str.append("\r\n");
        }


        logger.info(str.toString());
    }

    @AfterReturning(value = "alllog()", returning = "result")
    public void doafter(JoinPoint joinPoint, Object result) {
        System.out.print(result.toString());

        logger.info("info"+result.toString());

    }

}
