package com.example.sw.s6;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {
    private static Logger log = LoggerFactory.getLogger(LoginController.class);

    @PostMapping("/s6/login")
    public String login(@RequestParam String user, @RequestParam String password, Model model) {
        log.trace("enter login({})", user);

        if (!user.isBlank() && user.equals(password)) {
            model.addAttribute("name", user);
        }
        return "/s6/logged";
    }
}
