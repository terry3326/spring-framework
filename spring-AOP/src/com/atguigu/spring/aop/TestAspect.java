package com.atguigu.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class TestAspect {
    @Before("execution(* com.atguigu.spring.aop.*.*(..))")
    public void before(){
        System.out.println("TestAspect=>前置通知");
    }
}
