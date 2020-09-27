package com.atguigu.spring.scope;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Test {

	public static void main(String[] args) {
		
		ApplicationContext ac = new ClassPathXmlApplicationContext("/conf/scope.xml");
		Emp emp1 = ac.getBean("emp", Emp.class);
		Emp emp2 = ac.getBean("1", Emp.class);
//		System.out.println(emp1.equals(emp2));
		System.out.println(emp2);
	}
	
}
