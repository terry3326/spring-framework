package com.atguigu.spring.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect//標柱當前類為切面
@Order(1)//定義切面的優先級,值越小優先級越高,默認值為int的最大值
public class MyloggerAspect {
    /*
        設置公共切入點,讓其他調用
     */
    @Pointcut("execution(* com.atguigu.spring.aop.*.*(..))")
    public void test(){}


    /*
        @Before:將方法指定為前置通知
        必須設置value,其值為切入點表達式
        前置通知:作用於方法執行之前
        @Before("execution(* com.atguigu.spring.aop.*.*(..))")
        第一個＊代表任意的訪問修飾符和返回值類型
        第二個＊代表任意類
        第三個＊代表類中任意方法
        ..代表任意的參數列表
     */
//    @Before(value = "execution(public int com.atguigu.spring.aop.MathImpl.add(int,int))")
    @Before("test()")
    public void beforeMethod(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();//獲取方法的參數
        String methodName = joinPoint.getSignature().getName();//獲取方法名
        System.out.println("methodName: " + methodName + ", arguments: " + Arrays.toString(args));
    }

    /*
        @After:將方法標註為後置通知
        後置通知:作用於方法的finally語句塊,即不管有沒有異常都會執行
        不添加參數是因為在finally中,通常做關閉資源的功能,所以不用加參數
     */
//    @After("execution(* com.atguigu.spring.aop.*.*(..))")
    @After("test()")
    public void afterMethod() {
        System.out.println("後置通知");
    }

    /*
        @AfterReturning:將方法標註為返回通知
        返回通知:作用於方法執行之後
        可通過returning設置接收方法返回值的變量名
        要想在方法中使用，必須在方法的形參中設置和變量名（result）相同的參數名的參數（result）
     */
//    @AfterReturning(value = "execution(* com.atguigu.spring.aop.*.*(..))", returning = "result")
    @AfterReturning(value = "test()", returning = "result")
    public void afterReturningMethod(JoinPoint joinPoint, Object result) {
        String methodName = joinPoint.getSignature().getName();
        System.out.println("method: " + methodName + ", result: " + result);
    }

    /*
       @AfterThrowing:將方法標註為異常通知(例外通知)
       異常通知(例外通知):作用於方法拋出異常時
       可通過throwing設置接收方法返回值的變量名
       在參數列表中,可通過具體的異常類型,來對指定的異常訊息進行操作
     */
//    @AfterThrowing(value = "execution(* com.atguigu.spring.aop.*.*(..))", throwing = "ex")
    @AfterThrowing(value = "test()", throwing = "ex")
    public void AfterThrowingMethod(Exception ex) {
        System.out.println("有異常了,message: " + ex);
    }
    /*
        @Around:環繞通知
     */
//    @Around(value = "execution(* com.atguigu.spring.aop.*.*(..))")
//    public Object aroundMethod(ProceedingJoinPoint joinPoint){
//        Object result = null;
//
//        try {
//            //前置通知
//            System.out.println("前置通知");
//            joinPoint.proceed();//執行方法
//            //返回通知
//            System.out.println("返回通知");
//            return result;
//        } catch (Throwable throwable) {
//            throwable.printStackTrace();
//            //異常通知
//            System.out.println("異常通知");
//        } finally {
//            //後置通知
//            System.out.println("後置通知");
//       }
//        return -1;
//    }

}
