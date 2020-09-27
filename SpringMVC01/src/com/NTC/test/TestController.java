package com.atguigu.test;

import com.atguigu.bean.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TestController {

    /**
     * 假設:localhost:8080/SpringMVC01/hello
     */
    @RequestMapping("hello")//請求映射:RequestMapping()中的值,要跟前端網頁請求路徑一致,方法名跟映射路徑沒關係,不過建議跟路徑一致
    public String hello(String username,String password){//參數就是網頁夾帶參數的屬性的值(表單中參數的name值)
        System.out.println("username"+ username + "password" + password);
        return "success";//視圖名稱:也就是要跳轉到哪個jsp頁面的名稱
    }

    @RequestMapping("test")//請求映射:RequestMapping()中的值,要跟網頁請求路徑一致,方法名跟映射路徑沒關係,不過建議跟路徑一致
    public String test(User user){//如果User中有相對應屬性,會自動幫相對應屬性賦值
        System.out.println("SUCCESS");
        return "success";//視圖名稱:也就是要跳轉到哪個jsp頁面的名稱
    }
}
