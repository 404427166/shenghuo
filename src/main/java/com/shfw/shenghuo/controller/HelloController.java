package com.shfw.shenghuo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * ClassName:HelloController
 * Package:com.shfw.shenghuo.controller
 * Description:
 *
 * @Date:2020/2/11 22:18
 * @Author:404427166@qq.com
 */
@Controller
public class HelloController {
    @GetMapping("/hello")
    public String hello(@RequestParam(
            name = "name") String name, Model model){
        model.addAttribute("name",name);
        return "hello";
    }
}
