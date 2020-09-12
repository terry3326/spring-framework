package com.NTC.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
//@RequestMapping("/mvc")//通常情況下只會加value值
public class TestController {
    /**
     * View視圖類型
     * InternalResourceView:轉發視圖
     * JstlView:轉發視圖
     * Redirection:重定向視圖
     */
    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String test(String username, Model model){
        model.addAttribute("username", username);
        System.out.println(username);
//        return "redirect:/index.jsp";
        return "success";
    }
}
