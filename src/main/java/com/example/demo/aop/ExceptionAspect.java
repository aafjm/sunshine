package com.example.demo.aop;

import com.example.demo.bean.jo.ReturnJo;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.ResponseBody;

import java.lang.reflect.Method;

/**
 * Created by fengjiamin on 2018/3/20.
 */

@Aspect
@Component
public class ExceptionAspect {


    @Pointcut("execution(* com.example.demo.controller.*.*(..))")
    public void pointCut() {

    }

    @ResponseBody
    @Around("pointCut()")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {

        try {
            return joinPoint.proceed();
        } catch (Exception e) {
            return new ReturnJo(false, e.getMessage(), 500, "");
        }
    }

}
