package com.atguigu.spring.aop;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/conf/aop.xml");
        MathI math = context.getBean("mathImpl", MathI.class);
        System.out.println(math.getClass().getName());
        int add = math.div(1, 1);
//        System.out.println(add);
//
//        TestHandler testHandler = context.getBean("testHandler", TestHandler.class);
//        testHandler.test();

    }
}
