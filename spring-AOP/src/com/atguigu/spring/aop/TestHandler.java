package com.atguigu.spring.aop;

import org.springframework.stereotype.Component;

@Component
public class TestHandler {
    protected void test() {
        System.out.println("測試切入點表達式");
    }
}
