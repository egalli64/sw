package com.example.sw.s09;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/s09/hello")
public class HelloJSP {
    private static Logger log = LoggerFactory.getLogger(HelloJSP.class);

    @GetMapping
    public String hello() {
        log.trace("enter hello()");

        return "/s09/hello";
    }
}
