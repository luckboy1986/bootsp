package com.zhaomlb.club.bootsp.aop;


import com.fasterxml.jackson.core.JsonProcessingException;

import com.google.gson.Gson;
import com.zhaomlb.club.bootsp.entity.LogDto;
import com.zhaomlb.club.bootsp.service.LogService;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 日志记录
 */
@Aspect
@Component
public class AopLogslf4j {
    private final Logger logger = LoggerFactory.getLogger(AopLogslf4j.class);

    @Autowired
    private LogService logService;

    private static final Gson gson=new Gson();

    @Pointcut("execution(* com.zhaomlb.club.bootsp.controller..*(..))")
    public void alllog() {
    }

    @Before(value = "alllog()")
    public void doBefore(JoinPoint joinPoint) {
        LogDto logDto = new LogDto();
        logDto.setAopType("Before");
        logDto.setClsName(joinPoint.getTarget().getClass().getName());
        logDto.setMethod(joinPoint.getSignature().getName());


        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        String[] parameterNames = methodSignature.getParameterNames();

        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            StringBuilder str = new StringBuilder();
            str.append("参数类型:").append(args[i].getClass().getName());
            str.append("参数名称:").append(parameterNames[i]);
            str.append("参数值:").append(args[i]);
            logDto.setOrgs(str.toString());
        }
        logService.insert(logDto);

    }

    @Around(value = "alllog()")
    public Object doAround(ProceedingJoinPoint joinPoint) throws Throwable {
        Object result = null;
        LogDto logDto = new LogDto();
        try {

        } catch (Throwable e) {
            e.printStackTrace();
        }
        result = joinPoint.proceed();
        logDto.setAopType("doaroud");
        logDto.setClsName(joinPoint.getTarget().getClass().getName());
        logDto.setMethod(joinPoint.getSignature().getName());
        logService.insert(logDto);
        return result;


    }

    @AfterThrowing(pointcut = "alllog()",throwing = "error"   )
    public void dopException(JoinPoint joinPoint,Throwable  error) {
        LogDto logDto = new LogDto();
        logDto.setAopType("AfterThrowing");
        logDto.setClsName(joinPoint.getTarget().getClass().getName());
        logDto.setMethod(joinPoint.getSignature().getName());
        logDto.setResPonse(error.getMessage());

        logService.insert(logDto);
    }

    @AfterReturning(value = "alllog()", returning = "result")
    public void doafter(JoinPoint joinPoint, Object result) throws JsonProcessingException {
        LogDto logDto = new LogDto();
        logDto.setAopType("AfterReturning");
        logDto.setClsName(joinPoint.getTarget().getClass().getName());
        logDto.setMethod(joinPoint.getSignature().getName());
        logDto.setResPonse(gson.toJson(result));

        logService.insert(logDto);

    }

}
