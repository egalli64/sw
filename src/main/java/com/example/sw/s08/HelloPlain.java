package com.example.sw.s08;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/s08/hello")
public class HelloPlain {
    private static Logger log = LoggerFactory.getLogger(HelloPlain.class);

    // same as @GetMapping
    @RequestMapping(method = RequestMethod.GET)
    public String hello() {
        log.trace("enter");

        // redirect to the specified resource, not using standard view resolution
        return "redirect:/s08/hello.html";
    }
}
