package com.atguigu.spring.aopxml;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {
    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/conf/aop-xml.xml");
        MathI mathI = context.getBean("mathImpl", MathI.class);
        int add = mathI.add(12, 12);
        System.out.println(add);
    }
}
