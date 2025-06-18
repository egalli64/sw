package com.example.sw.s7;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class RegionPropertyCtrl {
    private static final Logger log = LogManager.getLogger(RegionPropertyCtrl.class);

    @Autowired
    private RegionRepo repo;

    @GetMapping("/s7p/region/all")
    public String getAll(Model model) {
        log.traceEntry("getAll");

        model.addAttribute("message", repo.getAll());

        return "/s7/result";
    }
}
