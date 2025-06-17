package com.example.sw.s3;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/s3/hello")
public class HelloPlain {
    private static Logger log = LoggerFactory.getLogger(HelloPlain.class);

    // the verbose alternative is
    // @RequestMapping(method = RequestMethod.GET)
    @GetMapping
    public String hello() {
        log.trace("enter hello()");

        // redirect to the specified resource, not using standard view resolution
        return "redirect:/s3/hello.html";
    }
}
