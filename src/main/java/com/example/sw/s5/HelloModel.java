package com.example.sw.s5;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloModel {
    private static Logger log = LoggerFactory.getLogger(HelloModel.class);

    @GetMapping("/s5/hello")
    public String helloModel(Model model) {
        log.trace("enter helloModel()");
        model.addAttribute("message", "A message by Model");
        return "/s5/hello";
    }

    @GetMapping("/s5/hello2")
    public String helloModelMap(ModelMap model) {
        log.trace("enter helloModelMap()");
        model.addAttribute("message", "A message by Model Map");
        return "/s5/hello";
    }

    @GetMapping("/s5/hello3")
    public ModelAndView helloModelAndView(ModelAndView mav) {
        log.trace("enter helloModelAndView()");
        mav.setViewName("/s5/hello");
        mav.addObject("message", "A message by ModelAndView");
        return mav;
    }

    @GetMapping("/s5/hello4")
    public ModelAndView helloModelAndViewLocal() {
        log.trace("enter helloModelAndViewLocal()");
        ModelAndView mav = new ModelAndView("/s5/hello");
        mav.addObject("message", "A message by ModelAndView (local)");
        return mav;
    }
}
