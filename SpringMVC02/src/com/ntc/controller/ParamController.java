package com.atguigu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ParamController {
    /**
     * 在springMVC獲取客戶端傳遞的數據的方式:
     * 1. 在處理請求的方法中,加入相對應的形參,保證形參參數名和傳遞的數據的參數名保持一致,就可以自動賦值
     * 2. @RequestParam
     * value: 當不滿足賦值條件時,可以使用value屬性,指定映射關係
     * required: 設置形參是否必須被賦值,默認為true:必須賦值,若設置為false,則不必須賦值,因此形參的值為null
     * defaultValue: 若形參所獲得的值為null,則設置一個默認值,用在分頁和模糊查詢中等相似情況
     */
//    @RequestMapping(value = "/param" ,method = RequestMethod.POST)
//    public String param(@RequestParam(value = "name",required = false,defaultValue = "admin") String username, String password, String age){
//        System.out.println("username = "+username+" , password = "+password+" , age = "+age);
//        return "success";
//    }

    /**
     * @RequestHeader: 處理請求的方法上,獲取請求頭信息,用法和@RequestParam一致
     */
//    @RequestMapping(value = "/param" ,method = RequestMethod.POST)
//    public String param(@RequestHeader("Accept-Language")String AcceptLanguage){
//        System.out.println("AcceptLanguage = "+AcceptLanguage);
//        return "success";
//    }

    /**
     * @CookieValue: 處理請求的方法上,獲取cookie信息,用法和@RequestParam一致
     */
//    @RequestMapping(value = "/param" ,method = RequestMethod.POST)
//    public String param(@CookieValue(value = "JSESSIONID")String JSESSIONID){
//        System.out.println("JSESSIONID = "+JSESSIONID);
//        return "success";
//    }

    /**
     * 可以使用POJO獲取客戶端數據,要求實體類對象中的屬性名一定要和頁面中表單元素name屬性值一致,且支持級聯關係(address.city)
     * 可以通過設置形參的方式,獲取servletAPI
     */
//    @RequestMapping(value = "/param" ,method = RequestMethod.POST)
//    public String param(User user, HttpServletRequest request){
//        String username = request.getParameter("username");
//        System.out.println(user);
//        return "success";
//    }

    /**
     * springMVC處理請求過程中,往作用域放值有以下三種方式
     * 總結:根據ModelAndView源碼調試,不管使用以下哪種方式,最終都會把model數據和view數據封裝到一個ModelAndView中
     */
//    @RequestMapping(value = "/param" ,method = RequestMethod.POST)
//    public ModelAndView param( ){
//        ModelAndView mav = new ModelAndView();
//        mav.addObject("username","root");//往request作用域放值
//        mav.setViewName("success");//設置視圖名稱,實現頁面跳轉
//        return mav;
//    }

//    @RequestMapping(value = "/param" ,method = RequestMethod.POST)
//    public String param(Map<String,Object> map){
//        map.put("username", "admin");//往request作用域放值
//        return "success";//返回視圖名稱
//    }

    @RequestMapping(value = "/param" ,method = RequestMethod.POST)
    public String param(Model model){
        model.addAttribute("username","張三");//往request作用域放值
        return "success";//返回視圖名稱
    }



}
