package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
//@RequestMapping("/mvc")//通常情況下只會加value值
public class TestController {
    /**
     *  @RequestMapping:設置請求映射,把請求和控制層中的方法設置映射關係
     *  當請求路徑和@RequestMapping的value屬性值一致時,則該註解所標註的方法即為處理請求的方法
     *
     *  @RequestMapping可以加在類上,也可以加在方法上
     *  若類和方法都有加,應該一層一層的訪問,先訪問類,在訪問類中的方法
     *  例:http://localhost:8080/SpringMVC02/mvc/test,才能訪問到此類中的方法
     *
     *  method:用來設置請求方式,只有客戶端發送請求的方法和method的值一致,才能處理請求
     *  請求方式:GET:查詢 POST:添加 PUT:修改 DELECTE:刪除
     *  params:用來設置客戶端傳到伺服器的數據,支持表達式(限制客戶端訪問參數是否滿足設置的規則才能訪問伺服器)
     *  header:用來設置請求頭(Request Headers)信息,所發送的請求的請求頭信息一定要和header屬性中所設置的一致(包括內容中元素的順序也要一致)
     *
     */
    @RequestMapping(value = "/test",
//            method = RequestMethod.POST,
//            params = {"username","age != 12"}//設定的條件越多,越難訪問到該方法
            headers = {"accept-language: zh-TW,zh;q=0.9,en;q=0.8,ja;q=0.7"}
            )//加/表示訪問項目下,不加表示當前目錄下,
    public String testPost(){
        System.out.println("SUCCESS:POST");
        return "success";
    }

    @RequestMapping(value = "/test",method = RequestMethod.GET)//加/表示訪問項目下,不加表示當前目錄下,
    public String testGet(){
        System.out.println("SUCCESS:GET");
        return "success";
    }
    /*
        在springMVC支持Ant方式的請求路徑
        在Ant中,有三種匹配符
        *:任意多個字符
        ?:任意一個字符
        **:任意多層字符
        例:http://localhost:8080/SpringMVC02 /abc/antMM/a/b/testAnt(前提是在類上沒有加 @RequestMapping)
     */

    @RequestMapping(value = "/*/ant??/**/testAnt")
    public String testAnt(){
        System.out.println("SUCCESS:testAnt");
        return "success";
    }
    /*
        以前:http://localhost:8080/SpringMVC02/testREST?id=1001&username=admin
        現在:http://localhost:8080/SpringMVC02/testREST/1001/admin
     */
    @RequestMapping("testREST/{id}/{username}")
    public String testREST(@PathVariable("id")Integer id,@PathVariable("username")String username){
        System.out.println("id: "+id+",username: "+username);
        return "success";
    }
}
