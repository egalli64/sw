package com.example.sw.s11;

import java.util.Arrays;
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
        if (count < 1 || count > 10) {
            log.warn(String.format("Count was %d, defaulted to 1", count));
            count = 1;
        }
        model.addAttribute("message", "hello!".repeat(count));
        return "/s11/hello";
    }

    @GetMapping("/s11/hello2")
    public String helloAlias(@RequestParam(name = "count") int i, Model model) {
        log.trace("enter helloAlias()");
        if (i < 1 || i > 10) {
            log.warn(String.format("Count was %d, defaulted to 1", i));
            i = 1;
        }

        model.addAttribute("message", "hello!".repeat(i));
        return "/s11/hello";
    }

    @GetMapping("/s11/hello3")
    public String helloNotRequired(@RequestParam(required = false) Integer count, Model model) {
        log.trace("enter helloAlias()");
        if (count != null) {
            if (count < 1 || count > 10) {
                log.warn(String.format("Count was %d, defaulted to 1", count));
                count = 1;
            }

            model.addAttribute("message", "hello!".repeat(count));
        }
        return "/s11/hello";
    }

    @GetMapping("/s11/hello4")
    public String helloOptional(@RequestParam Optional<Integer> count, Model model) {
        log.trace("enter helloOptional()");
        if (count.isPresent()) {
            int value = count.get();
            if (value < 1 || value > 10) {
                log.warn(String.format("Count was %d, defaulted to 1", value));
                value = 1;
            }
            model.addAttribute("message", "hello!".repeat(value));
        }
        return "/s11/hello";
    }

    @GetMapping("/s11/hello5")
    public String helloDefault(@RequestParam(defaultValue = "3") int count, Model model) {
        log.trace("enter helloDefault()");

        if (count < 1 || count > 10) {
            log.warn(String.format("Count was %d, defaulted to 1", count));
            count = 1;
        }
        model.addAttribute("message", "hello!".repeat(count));
        return "/s11/hello";
    }

    @GetMapping("/s11/hello6")
    public String helloList(@RequestParam int[] xs, Model model) {
        log.trace("enter helloDefault()");

        model.addAttribute("message", "X values: " + Arrays.toString(xs));
        return "/s11/hello";
    }
}
