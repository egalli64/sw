package com.example.sw.s11;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloParam {
    private static Logger log = LoggerFactory.getLogger(HelloParam.class);

    @GetMapping("/s11/hello")
    public String hello(@RequestParam int count, Model model) {
        log.trace("enter hello()");
        model.addAttribute("message", "hello!".repeat(count));
        return "/s11/hello";
    }

    @GetMapping("/s11/hello2")
    public String helloAlias(@RequestParam(name = "count") int i, Model model) {
        log.trace("enter helloAlias()");
        model.addAttribute("message", "hello!".repeat(i));
        return "/s11/hello";
    }

    @GetMapping("/s11/hello3")
    public String helloNotRequired(@RequestParam(required = false) Integer count, Model model) {
        log.trace("enter helloAlias()");
        if (count != null) {
            model.addAttribute("message", "hello!".repeat(count));
        }
        return "/s11/hello";
    }

    @GetMapping("/s11/hello4")
    public String helloOptional(@RequestParam Optional<Integer> count, Model model) {
        log.trace("enter helloAlias()");
        if (count.isPresent()) {
            model.addAttribute("message", "hello!".repeat(count.get()));
        }
        return "/s11/hello";
    }
}
