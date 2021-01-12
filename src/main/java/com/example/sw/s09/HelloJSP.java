package com.example.sw.s09;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/s09/hello")
public class HelloJSP {
    @GetMapping
    public String hello() {
        System.out.println("hello JSP");
        return "/s09/hello";
    }
}
