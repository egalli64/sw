package com.example.sw.s8;

import jakarta.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/s8")
public class MockLogger {
    private static Logger log = LoggerFactory.getLogger(MockLogger.class);

    @PostMapping("/login")
    public String login(@RequestParam String user, HttpSession session) {
        log.trace("enter login({})", user);
        if (user.isBlank()) {
            log.warn("default user used");
            session.setAttribute("user", "Guest");
        } else {
            session.setAttribute("user", user);
        }
        return "/s8/home";
    }

    @GetMapping("/logout")
    public String logout(HttpSession session) {
        log.trace("enter logout()");
        session.invalidate();
        return "/s8/home";
    }
}
