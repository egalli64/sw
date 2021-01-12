package com.example.sw.s10;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HelloModel {
    @GetMapping("/s10/hello")
    public String hello(Model model) {
        model.addAttribute("message", "A message generated in the controller");
        return "/s10/hello";
    }

    @GetMapping("/s10/hello2")
    public String hello2(ModelMap model) {
        model.addAttribute("message", "Another message generated in the controller");
        return "/s10/hello";
    }

    @GetMapping("/s10/hello3")
    public ModelAndView hello3(ModelAndView mav) {
        mav.setViewName("/s10/hello");
        mav.addObject("message", "A message generated in the controller on ModelAndView");
        return mav;
    }

    @GetMapping("/s10/hello4")
    public ModelAndView hello4() {
        ModelAndView mav = new ModelAndView("/s10/hello");
        mav.addObject("message", "Another message generated in the controller on ModelAndView");
        return mav;
    }
}
